package healthcare.model.entities;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Appointment entity with composition relationship to Patient and Clinician.
 * Demonstrates association between entities.
 */
public class Appointment extends BaseEntity {
    private String patientId;
    private String clinicianId;
    private String facilityId;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private int durationMinutes;
    private String appointmentType;
    private String status;
    private String reasonForVisit;
    private String notes;
    private LocalDate createdDate;
    private LocalDate lastModified;
    
    public Appointment(String appointmentId, String patientId, String clinicianId) {
        super(appointmentId);
        this.patientId = patientId;
        this.clinicianId = clinicianId;
        this.status = "Scheduled";
        this.createdDate = LocalDate.now();
        this.lastModified = LocalDate.now();
    }
    
    // Getters and Setters
    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    
    public String getClinicianId() { return clinicianId; }
    public void setClinicianId(String clinicianId) { this.clinicianId = clinicianId; }
    
    public String getFacilityId() { return facilityId; }
    public void setFacilityId(String facilityId) { this.facilityId = facilityId; }
    
    public LocalDate getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(LocalDate appointmentDate) { this.appointmentDate = appointmentDate; }
    
    public LocalTime getAppointmentTime() { return appointmentTime; }
    public void setAppointmentTime(LocalTime appointmentTime) { this.appointmentTime = appointmentTime; }
    
    public int getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(int durationMinutes) { this.durationMinutes = durationMinutes; }
    
    public String getAppointmentType() { return appointmentType; }
    public void setAppointmentType(String appointmentType) { this.appointmentType = appointmentType; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { 
        this.status = status; 
        this.lastModified = LocalDate.now();
    }
    
    public String getReasonForVisit() { return reasonForVisit; }
    public void setReasonForVisit(String reasonForVisit) { this.reasonForVisit = reasonForVisit; }
    
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    
    public LocalDate getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDate createdDate) { this.createdDate = createdDate; }
    
    public LocalDate getLastModified() { return lastModified; }
    public void setLastModified(LocalDate lastModified) { this.lastModified = lastModified; }
    
    // Business methods
    public void cancel() {
        this.status = "Cancelled";
        this.lastModified = LocalDate.now();
    }
    
    public void complete() {
        this.status = "Completed";
        this.lastModified = LocalDate.now();
    }
    
    public boolean isUpcoming() {
        return "Scheduled".equals(status) && 
               appointmentDate != null && 
               appointmentDate.isAfter(LocalDate.now().minusDays(1));
    }
    
    @Override
    public String toString() {
        return "Appointment " + getId() + ": " + appointmentDate + " at " + appointmentTime + " (" + status + ")";
    }
}
