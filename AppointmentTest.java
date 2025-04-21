import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {

	@Test
	public void testValidAppointment() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 2);
		Appointment appointment = new Appointment("a1", cal.getTime(), "Annual Checkup");

		assertEquals("a1", appointment.getAppointmentId());
		assertEquals("Annual Checkup", appointment.getDescription());
		assertTrue(appointment.getDate().after(new Date()));
	}

	@Test
	public void testNullIdThrows() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		assertThrows(IllegalArgumentException.class, () -> new Appointment(null, cal.getTime(), "Desc"));
	}

	@Test
	public void testLongIdThrows() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		assertThrows(IllegalArgumentException.class, () -> new Appointment("abcdefghijk", cal.getTime(), "Desc"));
	}

	@Test
	public void testPastDateThrows() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		assertThrows(IllegalArgumentException.class, () -> new Appointment("a1", cal.getTime(), "Past Event"));
	}

	@Test
	public void testNullDateThrows() {
		assertThrows(IllegalArgumentException.class, () -> new Appointment("a1", null, "No date"));
	}

	@Test
	public void testNullDescriptionThrows() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		assertThrows(IllegalArgumentException.class, () -> new Appointment("a1", cal.getTime(), null));
	}

	@Test
	public void testLongDescriptionThrows() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		String longDesc = "This description is way too long and should throw an exception immediately";
		assertThrows(IllegalArgumentException.class, () -> new Appointment("a1", cal.getTime(), longDesc));
	}
}
