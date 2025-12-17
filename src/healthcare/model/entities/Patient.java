<<<<<<< HEAD
package healthcare.model.entities;

import java.time.LocalDate;

public class Patient extends BaseEntity {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String nhsNumber;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;
    private String postcode;
    private String emergencyContactName;
    private String emergencyContactPhone;
    private LocalDate registrationDate;
    private String gpSurgeryId;
    
    public Patient(String patientId, String firstName, String lastName) {
        super(patientId);
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    // Getters and setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    
    public String getNhsNumber() { return nhsNumber; }
    public void setNhsNumber(String nhsNumber) { this.nhsNumber = nhsNumber; }
    
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    public String getPostcode() { return postcode; }
    public void setPostcode(String postcode) { this.postcode = postcode; }
    
    public String getEmergencyContactName() { return emergencyContactName; }
    public void setEmergencyContactName(String name) { this.emergencyContactName = name; }
    
    public String getEmergencyContactPhone() { return emergencyContactPhone; }
    public void setEmergencyContactPhone(String phone) { this.emergencyContactPhone = phone; }
    
    public LocalDate getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(LocalDate date) { this.registrationDate = date; }
    
    public String getGpSurgeryId() { return gpSurgeryId; }
    public void setGpSurgeryId(String id) { this.gpSurgeryId = id; }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    @Override
    public String toString() {
        return "Patient: " + getFullName() + " (NHS: " + nhsNumber + ")";
    }
}
=======
[PASTE THE Patient.java CODE HERE]
>>>>>>> backup-branch
