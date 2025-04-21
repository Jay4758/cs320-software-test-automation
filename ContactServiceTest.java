import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
	private ContactService service;
	private Contact contact;

	@BeforeEach
	public void setup() {
		service = new ContactService();
		contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
		service.addContact(contact);
	}

	@Test
	public void testAddDuplicateContact() {
		assertThrows(IllegalArgumentException.class, () -> service.addContact(contact));
	}

	@Test
	public void testDeleteContact() {
		service.deleteContact("123");
		assertThrows(IllegalArgumentException.class, () -> service.deleteContact("123"));
	}

	@Test
	public void testUpdateFirstName() {
		service.updateFirstName("123", "Jane");
		assertEquals("Jane", contact.getFirstName());
	}

	@Test
	public void testUpdateLastName() {
		service.updateLastName("123", "Smith");
		assertEquals("Smith", contact.getLastName());
	}

	@Test
	public void testUpdatePhone() {
		service.updatePhone("123", "0987654321");
		assertEquals("0987654321", contact.getPhone());
	}

	@Test
	public void testUpdateAddress() {
		service.updateAddress("123", "456 Park Ave");
		assertEquals("456 Park Ave", contact.getAddress());
	}

	@Test
	public void testUpdateNonExistingContact() {
		assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("999", "Test"));
	}

	@Test
	public void testAddNullContact() {
		assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
	}

	@Test
	public void testGetContact() {
		Contact result = service.getContact("123");
		assertNotNull(result);
		assertEquals("1234567890", result.getPhone());
	}

	@Test
	public void testGetNonExistingContact() {
		assertThrows(IllegalArgumentException.class, () -> service.getContact("999"));
	}
}
