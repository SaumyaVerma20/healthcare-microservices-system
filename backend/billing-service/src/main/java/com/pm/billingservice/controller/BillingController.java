package com.pm.billingservice.controller;

import com.pm.billingservice.dto.BillingRequestDTO;
import com.pm.billingservice.dto.BillingResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/billing")
public class BillingController {

    @PostMapping
    public ResponseEntity<BillingResponseDTO> createBillingAccount(@RequestBody BillingRequestDTO request) {
        System.out.println("Received billing request for: " + request.getName());

        // Mock business logic
        return ResponseEntity.ok(new BillingResponseDTO("ACC-" + System.currentTimeMillis(), "ACTIVE"));
    }
}