package healthcare.controller;
import healthcare.model.services.AppointmentService;
import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentController {
    private AppointmentService appointmentService;
    
    public AppointmentController() {
        this.appointmentService = new AppointmentService();
    }
    
    // FIXED: Remove duration parameter
    public boolean bookAppointment(String patientId, String clinicianId,
                                   LocalDate date, LocalTime time) {
        return appointmentService.bookAppointment(patientId, clinicianId, date, time);
    }
    
    public boolean cancelAppointment(String appointmentId) {
        return appointmentService.cancelAppointment(appointmentId);
    }
}
