import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Calendar;

public class AppointmentServiceTest {
	private AppointmentService service;
	private Appointment appointment;

	@BeforeEach
	public void setup() {
		service = new AppointmentService();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		appointment = new Appointment("a1", cal.getTime(), "Dentist Visit");
		service.addAppointment(appointment);
	}

	@Test
	public void testAddDuplicateThrows() {
		assertThrows(IllegalArgumentException.class, () -> service.addAppointment(appointment));
	}

	@Test
	public void testDeleteAppointment() {
		service.deleteAppointment("a1");
		assertNull(service.getAppointment("a1"));
	}

	@Test
	public void testDeleteNonExistingAppointmentDoesNotThrow() {
		assertDoesNotThrow(() -> service.deleteAppointment("nonexistent"));
	}

	@Test
	public void testAddNullAppointmentThrows() {
		assertThrows(IllegalArgumentException.class, () -> service.addAppointment(null));
	}

	@Test
	public void testGetExistingAppointment() {
		Appointment found = service.getAppointment("a1");
		assertNotNull(found);
		assertEquals("Dentist Visit", found.getDescription());
	}

	@Test
	public void testGetNonExistingAppointmentReturnsNull() {
		assertNull(service.getAppointment("notThere"));
	}
}
