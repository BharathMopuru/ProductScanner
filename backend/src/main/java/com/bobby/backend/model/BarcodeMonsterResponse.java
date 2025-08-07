package com.bobby.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BarcodeMonsterResponse {
    private String description;
    private String company;
    private String country;
}
