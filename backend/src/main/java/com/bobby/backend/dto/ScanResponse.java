package com.bobby.backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScanResponse {
    private boolean safe;
    private List<String> ingredients;
    private String message;
    private String productName;
    private String country;
    private String healthAnalysis;
}
