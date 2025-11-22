package com.pm.patientservice.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class BillingServiceClient {

    private final RestClient restClient;
    private final String billingServiceUrl;

    public BillingServiceClient(@Value("${billing.service.url}") String billingServiceUrl) {
        this.restClient = RestClient.create();
        this.billingServiceUrl = billingServiceUrl;
    }

    public void createBillingAccount(String patientId, String name, String email) {
        BillingRequestDTO request = new BillingRequestDTO(patientId, name, email);

        try {
            restClient.post()
                    .uri(billingServiceUrl)
                    .body(request)
                    .retrieve()
                    .toBodilessEntity();

            System.out.println("Successfully called Billing Service (REST)");
        } catch (Exception e) {
            System.err.println("Error calling Billing Service: " + e.getMessage());
            // In a real app, you might throw a custom exception here
        }
    }
}