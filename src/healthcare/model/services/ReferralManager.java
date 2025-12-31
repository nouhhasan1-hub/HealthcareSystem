package healthcare.model.services;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReferralManager {
    private static ReferralManager instance;
    private List<String> referrals = new ArrayList<>();
    private int counter = 1;
    
    private ReferralManager() {
        System.out.println("Singleton ReferralManager created");
    }
    
    public static ReferralManager getInstance() {
        if (instance == null) {
            instance = new ReferralManager();
        }
        return instance;
    }
    
    public void createReferral(String patientId, String reason) {
        String refId = "REF" + counter++;
        referrals.add(refId + ": " + reason);
        
        // Save to file as required
        saveToFile(refId, patientId, reason);
        System.out.println("Created referral: " + refId);
    }
    
    private void saveToFile(String refId, String patientId, String reason) {
        try {
            FileWriter writer = new FileWriter("output/referral_" + refId + ".txt");
            writer.write("Referral: " + refId + "\n");
            writer.write("Patient: " + patientId + "\n");
            writer.write("Reason: " + reason + "\n");
            writer.write("Date: " + LocalDateTime.now() + "\n");
            writer.close();
            System.out.println("  Saved to output/referral_" + refId + ".txt");
        } catch (Exception e) {
            System.out.println("  Error saving file: " + e.getMessage());
        }
    }
    
    public int getReferralCount() {
        return referrals.size();
    }
    
    // Test Singleton pattern
    public static boolean testSingleton() {
        ReferralManager m1 = ReferralManager.getInstance();
        ReferralManager m2 = ReferralManager.getInstance();
        return m1 == m2;
    }
}
