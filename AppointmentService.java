import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
	private final Map<String, Appointment> appointments = new HashMap<>();

	public void addAppointment(Appointment appointment) {
		if (appointment == null || appointments.containsKey(appointment.getAppointmentId())) {
			throw new IllegalArgumentException("Appointment is null or already exists");
		}
		appointments.put(appointment.getAppointmentId(), appointment);
	}

	public void deleteAppointment(String appointmentId) {
		appointments.remove(appointmentId);
	}

	public Appointment getAppointment(String appointmentId) {
		return appointments.get(appointmentId);
	}
}
