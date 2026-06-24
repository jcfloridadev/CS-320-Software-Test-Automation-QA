import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactTest {

    // Test valid contact creation
    @Test
    public void testValidContact() {

        Contact contact = new Contact(
                "12345",
                "Justin",
                "Florida",
                "1234567890",
                "123 Main Street");

        assertTrue(contact.getContactId().equals("12345"));
        assertTrue(contact.getFirstName().equals("Justin"));
        assertTrue(contact.getLastName().equals("Florida"));
        assertTrue(contact.getPhone().equals("1234567890"));
        assertTrue(contact.getAddress().equals("123 Main Street"));
    }

    // Test invalid contact ID
    @Test
    public void testInvalidContactId() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    null,
                    "Justin",
                    "Florida",
                    "1234567890",
                    "123 Main Street");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345678901",
                    "Justin",
                    "Florida",
                    "1234567890",
                    "123 Main Street");
        });
    }

    // Test invalid first name
    @Test
    public void testInvalidFirstName() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    null,
                    "Florida",
                    "1234567890",
                    "123 Main Street");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "VeryLongFirstName",
                    "Florida",
                    "1234567890",
                    "123 Main Street");
        });
    }

    // Test invalid last name
    @Test
    public void testInvalidLastName() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "Justin",
                    null,
                    "1234567890",
                    "123 Main Street");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "Justin",
                    "VeryLongLastName",
                    "1234567890",
                    "123 Main Street");
        });
    }

    // Test invalid phone number
    @Test
    public void testInvalidPhone() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "Justin",
                    "Florida",
                    "12345",
                    "123 Main Street");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "Justin",
                    "Florida",
                    null,
                    "123 Main Street");
        });
    }

    // Test invalid address
    @Test
    public void testInvalidAddress() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "Justin",
                    "Florida",
                    "1234567890",
                    null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "Justin",
                    "Florida",
                    "1234567890",
                    "1234567890123456789012345678901");
        });
    }
}