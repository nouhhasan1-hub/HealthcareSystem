package healthcare.model.dao;

import healthcare.model.entities.Patient;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    public static List<Patient> loadPatients(String filePath) {
        List<Patient> patients = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                
                String[] data = line.split(",");
                if (data.length >= 13) {
                    Patient patient = new Patient(data[0], data[1], data[2]);
                    
                    if (!data[3].isEmpty()) {
                        patient.setDateOfBirth(LocalDate.parse(data[3], DATE_FORMATTER));
                    }
                    
                    patient.setNhsNumber(data[4]);
                    patient.setGender(data[5]);
                    patient.setPhoneNumber(data[6]);
                    patient.setEmail(data[7]);
                    patient.setAddress(data[8]);
                    patient.setPostcode(data[9]);
                    patient.setEmergencyContactName(data[10]);
                    patient.setEmergencyContactPhone(data[11]);
                    
                    if (!data[12].isEmpty()) {
                        patient.setRegistrationDate(LocalDate.parse(data[12], DATE_FORMATTER));
                    }
                    
                    if (data.length > 13) {
                        patient.setGpSurgeryId(data[13]);
                    }
                    
                    patients.add(patient);
                }
            }
            System.out.println("✓ Loaded " + patients.size() + " patients from " + filePath);
            
        } catch (IOException e) {
            System.err.println("✗ Error loading patients: " + e.getMessage());
        }
        
        return patients;
    }
}
