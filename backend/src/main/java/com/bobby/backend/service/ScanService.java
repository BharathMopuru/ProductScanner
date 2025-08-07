package com.bobby.backend.service;

import com.bobby.backend.dto.ScanRequest;
import com.bobby.backend.dto.ScanResponse;
import com.bobby.backend.model.BarcodeMonsterResponse;
import com.bobby.backend.model.Ingredient;
import com.bobby.backend.model.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScanService {

    private static final String BARCODE_MONSTER_API_URL = "https://barcode.monster/api/";
    private static final String OPEN_FOOD_FACTS_API_URL = "https://world.openfoodfacts.org/api/v2/product/";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AiService aiService;

    public ScanResponse scan(ScanRequest scanRequest) {
        String barcode = scanRequest.getBarcode();

        // First, try barcode.monster
        try {
            String monsterUrl = BARCODE_MONSTER_API_URL + barcode;
            BarcodeMonsterResponse monsterResponse = restTemplate.getForObject(monsterUrl, BarcodeMonsterResponse.class);

            if (monsterResponse != null && monsterResponse.getDescription() != null) {
                return new ScanResponse(true, Collections.emptyList(), "Product: " + monsterResponse.getDescription(), monsterResponse.getDescription(), monsterResponse.getCountry(), null);
            }
        } catch (HttpClientErrorException e) {
            // Ignore and fall through to Open Food Facts
        }

        // Fallback to Open Food Facts
        String openFoodFactsUrl = OPEN_FOOD_FACTS_API_URL + barcode;
        try {
            ProductResponse productResponse = restTemplate.getForObject(openFoodFactsUrl, ProductResponse.class);

            if (productResponse != null && productResponse.getProduct() != null) {
                List<String> productIngredients = productResponse.getProduct().getIngredients() != null ?
                        productResponse.getProduct().getIngredients().stream()
                                .map(Ingredient::getText)
                                .collect(Collectors.toList()) :
                        Collections.emptyList();

                String healthAnalysis = aiService.getHealthAnalysis(productIngredients);

                List<String> unsafeIngredients = Arrays.asList("Aspartame", "Gluten");

                boolean isSafe = productIngredients.stream().noneMatch(unsafeIngredients::contains);
                String message = isSafe ? "Product is safe." : "Product contains unsafe ingredients.";

                return new ScanResponse(isSafe, productIngredients, message, productResponse.getProduct().getProductName(), productResponse.getProduct().getCountries(), healthAnalysis);
            } else {
                return new ScanResponse(false, Collections.emptyList(), "Product not found or has no ingredients.", null, null, null);
            }

        } catch (HttpClientErrorException.NotFound e) {
            return new ScanResponse(false, Collections.emptyList(), "Product not found on any service.", null, null, null);
        }
    }
}
