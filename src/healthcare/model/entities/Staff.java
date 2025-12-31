package healthcare.model.entities;

import java.time.LocalDate;

/**
 * Staff entity for non-clinical staff (administrative, support).
 * Demonstrates different roles and access levels.
 */
public class Staff extends BaseEntity {
    private String firstName;
    private String lastName;
    private String role;
    private String department;
    private String facilityId;
    private String phoneNumber;
    private String email;
    private String employmentStatus;
    private LocalDate startDate;
    private String lineManager;
    private String accessLevel;
    
    public Staff(String staffId, String firstName, String lastName, String role) {
        super(staffId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }
    
    // Getters and Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    
    public String getFacilityId() { return facilityId; }
    public void setFacilityId(String facilityId) { this.facilityId = facilityId; }
    
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getEmploymentStatus() { return employmentStatus; }
    public void setEmploymentStatus(String employmentStatus) { 
        this.employmentStatus = employmentStatus; 
    }
    
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    
    public String getLineManager() { return lineManager; }
    public void setLineManager(String lineManager) { this.lineManager = lineManager; }
    
    public String getAccessLevel() { return accessLevel; }
    public void setAccessLevel(String accessLevel) { this.accessLevel = accessLevel; }
    
    // Business methods
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    public boolean isAdministrative() {
        return "Administration".equalsIgnoreCase(department) ||
               "Practice Manager".equalsIgnoreCase(role) ||
               "Receptionist".equalsIgnoreCase(role) ||
               "Medical Secretary".equalsIgnoreCase(role);
    }
    
    public boolean isClinicalSupport() {
        return "Clinical Support".equalsIgnoreCase(department) ||
               "Healthcare Assistant".equalsIgnoreCase(role) ||
               "Nurse".equalsIgnoreCase(role);
    }
    
    public boolean hasManagerAccess() {
        return "Manager".equalsIgnoreCase(accessLevel);
    }
    
    public int getYearsOfService() {
        if (startDate == null) return 0;
        return LocalDate.now().getYear() - startDate.getYear();
    }
    
    @Override
    public String toString() {
        return getFullName() + " - " + role + " (" + department + ")";
    }
}
