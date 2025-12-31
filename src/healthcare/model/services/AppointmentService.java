package healthcare.model.services;
import healthcare.model.entities.Appointment;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentService {
    private List<Appointment> appointments = new ArrayList<>();
    
    // FIXED: Remove duration parameter to match controller
    public boolean bookAppointment(String patientId, String clinicianId,
                                   LocalDate date, LocalTime time) {
        String id = "A" + (appointments.size() + 101);
        Appointment appt = new Appointment(id, patientId, clinicianId);
        appt.setAppointmentDate(date);
        appt.setAppointmentTime(time);
        appt.setDurationMinutes(30); // Default duration
        appointments.add(appt);
        System.out.println("Booked: " + id);
        return true;
    }
    
    // FIXED: Add this missing method
    public boolean cancelAppointment(String appointmentId) {
        for (Appointment a : appointments) {
            if (a.getId().equals(appointmentId)) {
                appointments.remove(a);
                System.out.println("Cancelled: " + appointmentId);
                return true;
            }
        }
        return false;
    }
    
    public int getAppointmentCount() {
        return appointments.size();
    }
}
