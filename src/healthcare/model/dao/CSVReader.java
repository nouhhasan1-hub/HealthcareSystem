package healthcare.model.dao;

import healthcare.model.entities.Patient;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    public static List<Patient> loadPatients(String filePath) {
        List<Patient> patients = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // Skip header
            
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",", -1);
                if (data.length >= 3) {
                    try {
                        Patient patient = new Patient(data[0], data[1], data[2]);
                        
                        if (data.length > 3 && !data[3].isEmpty()) {
                            patient.setDateOfBirth(LocalDate.parse(data[3], DATE_FORMATTER));
                        }
                        if (data.length > 4) patient.setNhsNumber(data[4]);
                        if (data.length > 5) patient.setGender(data[5]);
                        if (data.length > 6) patient.setPhoneNumber(data[6]);
                        if (data.length > 7) patient.setEmail(data[7]);
                        if (data.length > 8) patient.setAddress(data[8]);
                        if (data.length > 9) patient.setPostcode(data[9]);
                        
                        patients.add(patient);
                    } catch (Exception e) {
                        // Skip invalid rows
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("CSV Error: " + e.getMessage());
        }
        
        return patients;
    }
}
