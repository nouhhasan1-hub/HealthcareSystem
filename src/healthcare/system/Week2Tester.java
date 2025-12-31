package healthcare.system;
import healthcare.model.services.*;
import healthcare.model.dao.CSVWriter;
import java.time.LocalDate;
import java.time.LocalTime;

public class Week2Tester {
    public static void main(String[] args) {
        System.out.println("=== WEEK 2 SIMPLE TEST ===");
        
        // Test 1: Services
        System.out.println("\n1. Testing PatientService:");
        PatientService ps = new PatientService();
        System.out.println("   Patients: " + ps.getPatientCount());
        
        // Test 2: Singleton Pattern
        System.out.println("\n2. Testing Singleton Pattern:");
        ReferralManager rm1 = ReferralManager.getInstance();
        ReferralManager rm2 = ReferralManager.getInstance();
        System.out.println("   Same instance? " + (rm1 == rm2));
        System.out.println("   Singleton test: " + ReferralManager.testSingleton());
        
        // Create referrals
        rm1.createReferral("P001", "Heart check");
        rm2.createReferral("P002", "Blood test");
        System.out.println("   Total referrals: " + rm1.getReferralCount());
        
        // Test 3: File Output
        System.out.println("\n3. Testing File Output:");
        boolean saved = CSVWriter.saveTextToFile("Test prescription", "prescription.txt");
        System.out.println("   File saved: " + saved);
        
        // Test 4: Check output folder
        System.out.println("\n4. Output folder check:");
        java.io.File outDir = new java.io.File("output");
        if (outDir.exists()) {
            String[] files = outDir.list();
            System.out.println("   Files in output/: " + files.length);
            for (String f : files) {
                System.out.println("   - " + f);
            }
        }
        
        System.out.println("\n=== WEEK 2 TEST COMPLETE ===");
    }
}
