package com.bobby.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    @JsonProperty("ingredients_text")
    private String ingredientsText;

    @JsonProperty("ingredients")
    private List<Ingredient> ingredients;

    @JsonProperty("product_name")
    private String productName;

    private String countries;
}
