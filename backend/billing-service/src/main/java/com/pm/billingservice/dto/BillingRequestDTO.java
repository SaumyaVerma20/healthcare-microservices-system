package com.pm.billingservice.dto;

public class BillingRequestDTO {
    private String patientId;
    private String name;
    private String email;

    // Constructors, Getters, Setters
    public BillingRequestDTO() {}

    public BillingRequestDTO(String patientId, String name, String email) {
        this.patientId = patientId;
        this.name = name;
        this.email = email;
    }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}