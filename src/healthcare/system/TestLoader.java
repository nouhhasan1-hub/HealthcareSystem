package healthcare.system;

import healthcare.model.dao.CSVReader;
import healthcare.model.entities.Patient;
import java.util.List;

public class TestLoader {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("HEALTHCARE SYSTEM - WEEK 1 TEST (DEBUG)");
        System.out.println("Student: Hasan (23021813)");
        System.out.println("Date: " + java.time.LocalDate.now());
        System.out.println("========================================\n");
        
        // Step 1: Verify environment
        System.out.println("STEP 1: ENVIRONMENT CHECK");
        System.out.println("Working directory: " + System.getProperty("user.dir"));
        System.out.println("Java version: " + System.getProperty("java.version"));
        
        // Step 2: Check file exists
        System.out.println("\nSTEP 2: FILE CHECK");
        String filePath = "data/patients.csv";
        java.io.File file = new java.io.File(filePath);
        
        if (!file.exists()) {
            System.out.println("✗ CRITICAL: File not found: " + file.getAbsolutePath());
            System.out.println("\nAvailable files in data/:");
            java.io.File dataDir = new java.io.File("data");
            if (dataDir.exists()) {
                String[] files = dataDir.list();
                if (files != null) {
                    for (String f : files) {
                        System.out.println("  - " + f + " (" + new java.io.File(dataDir, f).length() + " bytes)");
                    }
                }
            }
            return;
        }
        
        System.out.println("✓ File found: " + file.getAbsolutePath());
        System.out.println("File size: " + file.length() + " bytes");
        
        // Step 3: Show first few lines of CSV
        System.out.println("\nSTEP 3: CSV PREVIEW (first 3 lines)");
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(file))) {
            for (int i = 0; i < 3; i++) {
                String line = br.readLine();
                if (line != null) {
                    System.out.println("Line " + (i+1) + ": " + line);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        // Step 4: Load patients
        System.out.println("\nSTEP 4: LOADING PATIENTS");
        System.out.println("Calling CSVReader.loadPatients(\"" + filePath + "\")");
        
        List<Patient> patients = CSVReader.loadPatients(filePath);
        
        // Step 5: Results
        System.out.println("\nSTEP 5: RESULTS");
        if (patients == null) {
            System.out.println("✗ CSVReader returned null");
        } else if (patients.isEmpty()) {
            System.out.println("✗ No patients loaded - check CSV format");
        } else {
            System.out.println("✓ SUCCESS: Loaded " + patients.size() + " patients");
            
            System.out.println("\n--- PATIENT DETAILS ---");
            for (int i = 0; i < Math.min(5, patients.size()); i++) {
                Patient p = patients.get(i);
                System.out.println("\nPatient " + (i+1) + ":");
                System.out.println("  ID: " + p.getId());
                System.out.println("  Name: " + p.getFullName());
                System.out.println("  NHS: " + p.getNhsNumber());
                System.out.println("  DOB: " + p.getDateOfBirth());
                System.out.println("  Phone: " + p.getPhoneNumber());
                System.out.println("  Email: " + p.getEmail());
            }
            
            // Verify inheritance
            System.out.println("\n--- INHERITANCE VERIFICATION ---");
            if (!patients.isEmpty()) {
                Patient sample = patients.get(0);
                System.out.println("BaseEntity.getId(): " + sample.getId());
                System.out.println("Patient.toString(): " + sample.toString());
                System.out.println("Patient instanceof BaseEntity: " + (sample instanceof healthcare.model.entities.BaseEntity));
            }
        }
        
        System.out.println("\n========================================");
        System.out.println("DEBUG COMPLETE");
        System.out.println("========================================");
    }
}
