package com.pm.patientservice.client;

public class BillingRequestDTO {
    private String patientId;
    private String name;
    private String email;

    public BillingRequestDTO(String patientId, String name, String email) {
        this.patientId = patientId;
        this.name = name;
        this.email = email;
    }
    // Getters and Setters (Omitted for brevity, but standard)
    public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
}