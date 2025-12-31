package healthcare.system;

import healthcare.model.dao.CSVReader;
import healthcare.model.entities.Patient;
import java.util.List;

public class TestLoader {
    public static void main(String[] args) {
        System.out.println(" HEALTHCARE SYSTEM - WEEK 1 FINAL TEST");
        System.out.println("==========================================");
        System.out.println("Student: Hasan (23021813)");
        System.out.println("Test: CSV Loading with Fixed Data");
        System.out.println("==========================================\n");
        
        // Verify file exists
        java.io.File csvFile = new java.io.File("data/patients.csv");
        if (!csvFile.exists()) {
            System.out.println(" ERROR: patients.csv not found!");
            System.out.println("Looking in: " + csvFile.getAbsolutePath());
            return;
        }
        
        System.out.println("✓ File found: " + csvFile.getAbsolutePath());
        System.out.println("File size: " + csvFile.length() + " bytes\n");
        
        // Load patients
        System.out.println(" Loading patient data...");
        List<Patient> patients = CSVReader.loadPatients("data/patients.csv");
        
        // Display results
        System.out.println("\n TEST RESULTS");
        System.out.println("================");
        
        if (patients == null) {
            System.out.println(" CSVReader returned null - critical error");
        } else if (patients.isEmpty()) {
            System.out.println("⚠️  Loaded 0 patients - check CSV format");
        } else {
            System.out.println(" SUCCESS: Loaded " + patients.size() + " patients\n");
            
            System.out.println(" PATIENT LIST:");
            System.out.println("----------------");
            for (int i = 0; i < patients.size(); i++) {
                Patient p = patients.get(i);
                System.out.printf("%2d. %-20s | NHS: %-10s | DOB: %s\n", 
                    (i+1), p.getFullName(), p.getNhsNumber(), p.getDateOfBirth());
            }
            
            // Verify OOP principles
            System.out.println("\n OOP VERIFICATION:");
            System.out.println("-------------------");
            if (!patients.isEmpty()) {
                Patient sample = patients.get(0);
                System.out.println("1. Inheritance check:");
                System.out.println("   Patient extends BaseEntity: " + 
                    (sample instanceof healthcare.model.entities.BaseEntity));
                System.out.println("   BaseEntity.getId(): " + sample.getId());
                
                System.out.println("\n2. Encapsulation check:");
                System.out.println("   Using getters: " + sample.getFullName());
                System.out.println("   Using toString: " + sample.toString());
            }
        }
        
        System.out.println("\n==========================================");
        System.out.println(" WEEK 1 IMPLEMENTATION COMPLETE");
        System.out.println("==========================================");
    }
}
