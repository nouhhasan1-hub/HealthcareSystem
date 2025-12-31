package healthcare.model.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Facility entity representing healthcare facilities (GP surgeries, hospitals).
 * Demonstrates collection relationships with specialities.
 */
public class Facility extends BaseEntity {
    private String facilityName;
    private String facilityType;
    private String address;
    private String postcode;
    private String phoneNumber;
    private String email;
    private String openingHours;
    private String managerName;
    private int capacity;
    private List<String> specialitiesOffered;
    
    public Facility(String facilityId, String facilityName, String facilityType) {
        super(facilityId);
        this.facilityName = facilityName;
        this.facilityType = facilityType;
        this.specialitiesOffered = new ArrayList<>();
    }
    
    // Getters and Setters
    public String getFacilityName() { return facilityName; }
    public void setFacilityName(String facilityName) { this.facilityName = facilityName; }
    
    public String getFacilityType() { return facilityType; }
    public void setFacilityType(String facilityType) { this.facilityType = facilityType; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    public String getPostcode() { return postcode; }
    public void setPostcode(String postcode) { this.postcode = postcode; }
    
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getOpeningHours() { return openingHours; }
    public void setOpeningHours(String openingHours) { this.openingHours = openingHours; }
    
    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) { this.managerName = managerName; }
    
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    
    public List<String> getSpecialitiesOffered() { 
        return new ArrayList<>(specialitiesOffered); 
    }
    
    // Business methods
    public void addSpeciality(String speciality) {
        if (!specialitiesOffered.contains(speciality)) {
            specialitiesOffered.add(speciality);
        }
    }
    
    public void removeSpeciality(String speciality) {
        specialitiesOffered.remove(speciality);
    }
    
    public boolean hasSpeciality(String speciality) {
        return specialitiesOffered.contains(speciality);
    }
    
    public boolean isHospital() {
        return "Hospital".equalsIgnoreCase(facilityType);
    }
    
    public boolean isGpSurgery() {
        return "GP Surgery".equalsIgnoreCase(facilityType) || 
               "GP".equalsIgnoreCase(facilityType);
    }
    
    @Override
    public String toString() {
        return facilityName + " (" + facilityType + ") - " + address;
    }
}