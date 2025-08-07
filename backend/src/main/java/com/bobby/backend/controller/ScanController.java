package com.bobby.backend.controller;

import com.bobby.backend.dto.ScanRequest;
import com.bobby.backend.dto.ScanResponse;
import com.bobby.backend.service.ScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/scan")
public class ScanController {

    @Autowired
    private ScanService scanService;

    @PostMapping
    public ScanResponse scan(@RequestBody ScanRequest scanRequest) {
        return scanService.scan(scanRequest);
    }
}
