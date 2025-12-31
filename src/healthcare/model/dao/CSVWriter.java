package healthcare.model.dao;
import java.io.FileWriter;

public class CSVWriter {
    public static boolean saveTextToFile(String text, String filename) {
        try {
            FileWriter writer = new FileWriter("output/" + filename);
            writer.write(text);
            writer.close();
            System.out.println("Saved: output/" + filename);
            return true;
        } catch (Exception e) {
            System.out.println("Error saving: " + e.getMessage());
            return false;
        }
    }
}
