package com.pm.patientservice.client;

public class BillingResponseDTO {
    private String accountId;
    private String status;

    // Getters/Setters
    public String getAccountId() { return accountId; }
    public void setAccountId(String accountId) { this.accountId = accountId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}