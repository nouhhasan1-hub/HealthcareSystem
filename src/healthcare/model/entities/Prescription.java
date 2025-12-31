package healthcare.model.entities;

import java.time.LocalDate;

/**
 * Prescription entity demonstrating composition with Patient and Drug.
 */
public class Prescription extends BaseEntity {
    private String patientId;
    private String clinicianId;
    private String appointmentId;
    private LocalDate prescriptionDate;
    private String medicationName;
    private String dosage;
    private String frequency;
    private int durationDays;
    private int quantity;
    private String instructions;
    private String pharmacyName;
    private String status;
    private LocalDate issueDate;
    private LocalDate collectionDate;
    
    public Prescription(String prescriptionId, String patientId, String clinicianId) {
        super(prescriptionId);
        this.patientId = patientId;
        this.clinicianId = clinicianId;
        this.prescriptionDate = LocalDate.now();
        this.issueDate = LocalDate.now();
        this.status = "Issued";
    }
    
    // Getters and Setters (all fields)
    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    
    public String getClinicianId() { return clinicianId; }
    public void setClinicianId(String clinicianId) { this.clinicianId = clinicianId; }
    
    public String getAppointmentId() { return appointmentId; }
    public void setAppointmentId(String appointmentId) { this.appointmentId = appointmentId; }
    
    public LocalDate getPrescriptionDate() { return prescriptionDate; }
    public void setPrescriptionDate(LocalDate prescriptionDate) { this.prescriptionDate = prescriptionDate; }
    
    public String getMedicationName() { return medicationName; }
    public void setMedicationName(String medicationName) { this.medicationName = medicationName; }
    
    public String getDosage() { return dosage; }
    public void setDosage(String dosage) { this.dosage = dosage; }
    
    public String getFrequency() { return frequency; }
    public void setFrequency(String frequency) { this.frequency = frequency; }
    
    public int getDurationDays() { return durationDays; }
    public void setDurationDays(int durationDays) { this.durationDays = durationDays; }
    
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    
    public String getInstructions() { return instructions; }
    public void setInstructions(String instructions) { this.instructions = instructions; }
    
    public String getPharmacyName() { return pharmacyName; }
    public void setPharmacyName(String pharmacyName) { this.pharmacyName = pharmacyName; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public LocalDate getIssueDate() { return issueDate; }
    public void setIssueDate(LocalDate issueDate) { this.issueDate = issueDate; }
    
    public LocalDate getCollectionDate() { return collectionDate; }
    public void setCollectionDate(LocalDate collectionDate) { this.collectionDate = collectionDate; }
    
    // Business methods
    public void markAsCollected() {
        this.status = "Collected";
        this.collectionDate = LocalDate.now();
    }
    
    public boolean isActive() {
        return "Issued".equals(status) || "Active".equals(status);
    }
    
    @Override
    public String toString() {
        return "Prescription " + getId() + ": " + medicationName + " for " + durationDays + " days";
    }
}