package healthcare.model.entities;

/**
 * Clinician entity demonstrating inheritance hierarchy.
 * HealthcareProfessional (abstract) ← Clinician (concrete)
 */
public class Clinician extends BaseEntity {
    private String firstName;
    private String lastName;
    private String title;
    private String speciality;
    private String gmcNumber;
    private String phoneNumber;
    private String email;
    private String workplaceId;
    private String workplaceType;
    private String employmentStatus;
    private String startDate;
    
    public Clinician(String clinicianId, String firstName, String lastName, String title) {
        super(clinicianId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
    }
    
    // Getters and Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getSpeciality() { return speciality; }
    public void setSpeciality(String speciality) { this.speciality = speciality; }
    
    public String getGmcNumber() { return gmcNumber; }
    public void setGmcNumber(String gmcNumber) { this.gmcNumber = gmcNumber; }
    
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getWorkplaceId() { return workplaceId; }
    public void setWorkplaceId(String workplaceId) { this.workplaceId = workplaceId; }
    
    public String getWorkplaceType() { return workplaceType; }
    public void setWorkplaceType(String workplaceType) { this.workplaceType = workplaceType; }
    
    public String getEmploymentStatus() { return employmentStatus; }
    public void setEmploymentStatus(String employmentStatus) { this.employmentStatus = employmentStatus; }
    
    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }
    
    public String getFullName() {
        return title + " " + firstName + " " + lastName;
    }
    
    @Override
    public String toString() {
        return getFullName() + " - " + speciality + " (" + workplaceId + ")";
    }
}
