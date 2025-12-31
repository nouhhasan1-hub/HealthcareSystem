package healthcare.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Referral entity for Singleton pattern demonstration.
 */
public class Referral extends BaseEntity {
    private String patientId;
    private String referringClinicianId;
    private String referredToClinicianId;
    private String referringFacilityId;
    private String referredToFacilityId;
    private LocalDate referralDate;
    private String urgencyLevel;
    private String referralReason;
    private String clinicalSummary;
    private List<String> requestedInvestigations;
    private String status;
    private String appointmentId;
    private String notes;
    private LocalDate createdDate;
    private LocalDate lastUpdated;
    
    public Referral(String referralId, String patientId, String referringClinicianId) {
        super(referralId);
        this.patientId = patientId;
        this.referringClinicianId = referringClinicianId;
        this.referralDate = LocalDate.now();
        this.createdDate = LocalDate.now();
        this.lastUpdated = LocalDate.now();
        this.requestedInvestigations = new ArrayList<>();
        this.status = "New";
    }
    
    // Getters and Setters
    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    
    public String getReferringClinicianId() { return referringClinicianId; }
    public void setReferringClinicianId(String referringClinicianId) { this.referringClinicianId = referringClinicianId; }
    
    public String getReferredToClinicianId() { return referredToClinicianId; }
    public void setReferredToClinicianId(String referredToClinicianId) { this.referredToClinicianId = referredToClinicianId; }
    
    public String getReferringFacilityId() { return referringFacilityId; }
    public void setReferringFacilityId(String referringFacilityId) { this.referringFacilityId = referringFacilityId; }
    
    public String getReferredToFacilityId() { return referredToFacilityId; }
    public void setReferredToFacilityId(String referredToFacilityId) { this.referredToFacilityId = referredToFacilityId; }
    
    public LocalDate getReferralDate() { return referralDate; }
    public void setReferralDate(LocalDate referralDate) { this.referralDate = referralDate; }
    
    public String getUrgencyLevel() { return urgencyLevel; }
    public void setUrgencyLevel(String urgencyLevel) { this.urgencyLevel = urgencyLevel; }
    
    public String getReferralReason() { return referralReason; }
    public void setReferralReason(String referralReason) { this.referralReason = referralReason; }
    
    public String getClinicalSummary() { return clinicalSummary; }
    public void setClinicalSummary(String clinicalSummary) { this.clinicalSummary = clinicalSummary; }
    
    public List<String> getRequestedInvestigations() { return new ArrayList<>(requestedInvestigations); }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { 
        this.status = status; 
        this.lastUpdated = LocalDate.now();
    }
    
    public String getAppointmentId() { return appointmentId; }
    public void setAppointmentId(String appointmentId) { this.appointmentId = appointmentId; }
    
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    
    public LocalDate getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDate createdDate) { this.createdDate = createdDate; }
    
    public LocalDate getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(LocalDate lastUpdated) { this.lastUpdated = lastUpdated; }
    
    // Business methods
    public void addInvestigation(String investigation) {
        requestedInvestigations.add(investigation);
        this.lastUpdated = LocalDate.now();
    }
    
    public void updateStatus(String newStatus) {
        this.status = newStatus;
        this.lastUpdated = LocalDate.now();
    }
    
    public boolean isPending() {
        return "New".equals(status) || "Pending".equals(status);
    }
    
    @Override
    public String toString() {
        return "Referral " + getId() + ": " + referralReason + " (" + urgencyLevel + ") - " + status;
    }
}