package healthcare.system;

import healthcare.model.dao.CSVReader;
import healthcare.model.entities.Patient;
import java.util.List;

public class TestLoader {
    public static void main(String[] args) {
        System.out.println("=== Healthcare System - Week 1 Test ===");
        System.out.println("Student: Hasan (23021813)");
        System.out.println("Testing CSV data loading...\n");
        
        // Load patients
        List<Patient> patients = CSVReader.loadPatients("data/patients.csv");
        
        if (!patients.isEmpty()) {
            System.out.println("First 3 patients:");
            for (int i = 0; i < Math.min(3, patients.size()); i++) {
                Patient p = patients.get(i);
                System.out.println((i+1) + ". " + p.getFullName() + 
                                 " | DOB: " + p.getDateOfBirth() + 
                                 " | NHS: " + p.getNhsNumber());
            }
            System.out.println("\n✓ Total patients loaded: " + patients.size());
        } else {
            System.out.println("✗ No patients loaded. Check data file.");
        }
        
        System.out.println("\n=== Test Complete ===");
    }
}
