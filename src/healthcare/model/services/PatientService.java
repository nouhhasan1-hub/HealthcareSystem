package healthcare.model.services;
import healthcare.model.entities.Patient;
import healthcare.model.dao.CSVReader;
import java.util.List;
import java.util.ArrayList;

public class PatientService {
    private List<Patient> patients;
    
    public PatientService() {
        patients = CSVReader.loadPatients("data/patients.csv");
        if (patients == null) patients = new ArrayList<>();
    }
    
    // FIXED: Add these missing methods
    public List<Patient> getAllPatients() {
        return new ArrayList<>(patients);
    }
    
    public Patient getPatientById(String patientId) {
        for (Patient p : patients) {
            if (p.getId().equals(patientId)) {
                return p;
            }
        }
        return null;
    }
    
    public boolean addPatient(Patient patient) {
        patients.add(patient);
        return true;
    }
    
    public boolean updatePatient(String patientId, Patient patient) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId().equals(patientId)) {
                patients.set(i, patient);
                return true;
            }
        }
        return false;
    }
    
    public boolean deletePatient(String patientId) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId().equals(patientId)) {
                patients.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public int getPatientCount() {
        return patients.size();
    }
}
