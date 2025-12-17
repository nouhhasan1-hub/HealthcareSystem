package healthcare.system;

import healthcare.model.dao.CSVReader;
import healthcare.model.entities.Patient;
import java.util.List;

public class TestLoader {
    public static void main(String[] args) {
        System.out.println("=== Healthcare System - Week 1 Test ===");
        System.out.println("Student: Hasan (23021813)");
        System.out.println("Testing CSV Patient Data Loading");
        System.out.println("=======================================\n");
        
        // Test patient loading
        String filePath = "data/patients.csv";
        System.out.println("Loading patients from: " + filePath);
        
        List<Patient> patients = CSVReader.loadPatients(filePath);
        
        if (patients != null && !patients.isEmpty()) {
            System.out.println("\n✓ SUCCESS: Loaded " + patients.size() + " patients");
            
            // Show sample data
            System.out.println("\n--- Sample Patient Data (First 3) ---");
            for (int i = 0; i < Math.min(3, patients.size()); i++) {
                Patient p = patients.get(i);
                System.out.println((i+1) + ". " + p.getFullName() + 
                                 " | NHS: " + p.getNhsNumber() + 
                                 " | DOB: " + p.getDateOfBirth());
            }
            
            // Show data validation
            System.out.println("\n--- Data Validation ---");
            int validNHS = 0;
            for (Patient p : patients) {
                if (p.getNhsNumber() != null && !p.getNhsNumber().isEmpty()) {
                    validNHS++;
                }
            }
            System.out.println("Patients with valid NHS numbers: " + validNHS + "/" + patients.size());
            
        } else {
            System.out.println("\n✗ FAILED: Could not load patients");
        }
        
        System.out.println("\n=== Week 1 Test Complete ===");
    }
}
