import java.util.Date;

public class Appointment {
	private final String appointmentId;
	private final Date date;
	private final String description;

	public Appointment(String appointmentId, Date date, String description) {
		if (appointmentId == null || appointmentId.length() > 10)
			throw new IllegalArgumentException("Invalid Appointment ID");
		if (date == null || date.before(new Date()))
			throw new IllegalArgumentException("Date must be in the future");
		if (description == null || description.length() > 50)
			throw new IllegalArgumentException("Invalid Description");

		this.appointmentId = appointmentId;
		this.date = new Date(date.getTime()); // defensive copy
		this.description = description;
	}

	public String getAppointmentId() {
		return appointmentId;
	}

	public Date getDate() {
		return new Date(date.getTime()); // defensive copy
	}

	public String getDescription() {
		return description;
	}
}
