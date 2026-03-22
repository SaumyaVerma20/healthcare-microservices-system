package com.pm.billingservice.dto;

public class BillingResponseDTO {
    private String accountId;
    private String status;

    public BillingResponseDTO(String accountId, String status) {
        this.accountId = accountId;
        this.status = status;
    }

    public String getAccountId() { return accountId; }
    public void setAccountId(String accountId) { this.accountId = accountId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}