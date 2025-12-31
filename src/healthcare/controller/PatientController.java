package healthcare.controller;

import healthcare.model.entities.Patient;
import healthcare.model.services.PatientService;
import java.util.List;

public class PatientController {
    private PatientService patientService;
    
    public PatientController() {
        this.patientService = new PatientService();
    }
    
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }
    
    public Patient getPatientById(String patientId) {
        return patientService.getPatientById(patientId);
    }
    
    public boolean addPatient(Patient patient) {
        return patientService.addPatient(patient);
    }
    
    public boolean updatePatient(String patientId, Patient patient) {
        return patientService.updatePatient(patientId, patient);
    }
    
    public boolean deletePatient(String patientId) {
        return patientService.deletePatient(patientId);
    }
}
