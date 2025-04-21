import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("123", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("123", "John", "Doe", "123", "123 Main St"));
    }

    @Test
    public void testNullValues() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("123", null, "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("123", "John", null, "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("123", "John", "Doe", null, "123 Main St"));
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("123", "John", "Doe", "1234567890", null));
    }

    @Test
    public void testInvalidLengths() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("123", "VeryLongFirstName", "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("123", "John", "VeryLongLastName", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("123", "John", "Doe", "1234567890", "A very very very very long address that should fail"));
    }

    @Test
    public void testSetters() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Mike");
        contact.setLastName("Smith");
        contact.setPhone("0987654321");
        contact.setAddress("456 Elm St");

        assertEquals("Mike", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Elm St", contact.getAddress());
    }
}
