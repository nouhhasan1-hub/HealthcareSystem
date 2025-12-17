package healthcare.model.dao;

import healthcare.model.entities.Patient;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    public static List<Patient> loadPatients(String filePath) {
        List<Patient> patients = new ArrayList<>();
        int successCount = 0;
        int errorCount = 0;
        
        System.out.println("\n=== CSV READING DEBUG ===");
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            int lineNumber = 0;
            
            while ((line = br.readLine()) != null) {
                lineNumber++;
                
                if (isHeader) {
                    System.out.println("Header line: " + line);
                    isHeader = false;
                    continue;
                }
                
                System.out.println("\nLine " + lineNumber + ": " + line);
                
                // Split CSV line properly
                String[] data = parseCSVLine(line);
                System.out.println("Parsed into " + data.length + " columns");
                
                if (data.length >= 13) {
                    try {
                        // Create patient with first 3 fields
                        Patient patient = new Patient(
                            cleanField(data[0]),  // patient_id
                            cleanField(data[1]),  // first_name
                            cleanField(data[2])   // last_name
                        );
                        
                        // Parse date of birth (column 4)
                        if (!cleanField(data[3]).isEmpty()) {
                            try {
                                patient.setDateOfBirth(LocalDate.parse(cleanField(data[3]), DATE_FORMATTER));
                                System.out.println("  DOB parsed: " + cleanField(data[3]));
                            } catch (DateTimeParseException e) {
                                System.out.println("  DOB parse failed: " + cleanField(data[3]));
                            }
                        }
                        
                        // Set other fields
                        patient.setNhsNumber(cleanField(data[4]));      // nhs_number
                        patient.setGender(cleanField(data[5]));         // gender
                        patient.setPhoneNumber(cleanField(data[6]));    // phone - NOT a date!
                        patient.setEmail(cleanField(data[7]));          // email
                        patient.setAddress(cleanField(data[8]));        // address
                        patient.setPostcode(cleanField(data[9]));       // postcode
                        patient.setEmergencyContactName(cleanField(data[10]));    // emergency_contact_name
                        patient.setEmergencyContactPhone(cleanField(data[11]));   // emergency_contact_phone
                        
                        // Parse registration date
                        if (!cleanField(data[12]).isEmpty()) {
                            try {
                                patient.setRegistrationDate(LocalDate.parse(cleanField(data[12]), DATE_FORMATTER));
                            } catch (DateTimeParseException e) {
                                // Skip if can't parse
                            }
                        }
                        
                        // GP surgery ID if present
                        if (data.length > 13) {
                            patient.setGpSurgeryId(cleanField(data[13]));
                        }
                        
                        patients.add(patient);
                        successCount++;
                        System.out.println("  ✓ Added patient: " + patient.getFullName());
                        
                    } catch (Exception e) {
                        errorCount++;
                        System.out.println("  ✗ Error on line " + lineNumber + ": " + e.getMessage());
                    }
                } else {
                    errorCount++;
                    System.out.println("  ✗ Line " + lineNumber + " has only " + data.length + " columns (need 13+)");
                }
            }
            
            System.out.println("\n=== LOADING SUMMARY ===");
            System.out.println("Total lines processed: " + (lineNumber - 1));
            System.out.println("Successfully loaded: " + successCount);
            System.out.println("Errors: " + errorCount);
            
        } catch (IOException e) {
            System.err.println("File error: " + e.getMessage());
            return null;
        }
        
        return patients;
    }
    
    /**
     * Parse a CSV line, handling quoted fields
     */
    private static String[] parseCSVLine(String line) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;
        
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                result.add(current.toString());
                current = new StringBuilder();
            } else {
                current.append(c);
            }
        }
        result.add(current.toString());
        
        return result.toArray(new String[0]);
    }
    
    /**
     * Clean field - remove quotes and trim
     */
    private static String cleanField(String field) {
        if (field == null) return "";
        field = field.trim();
        if (field.startsWith("\"") && field.endsWith("\"")) {
            field = field.substring(1, field.length() - 1);
        }
        return field;
    }
}
