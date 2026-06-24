import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    // Test adding a contact
    @Test
    public void testAddContact() {

        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "Justin", "Florida", "1234567890", "123 Main Street");

        service.addContact(contact);

        assertNotNull(service.getContact("12345"));
        assertEquals("Justin", service.getContact("12345").getFirstName());
    }

    // Test adding duplicate contact ID
    @Test
    public void testAddDuplicateContact() {

        ContactService service = new ContactService();
        Contact contact1 = new Contact("12345", "Justin", "Florida", "1234567890", "123 Main Street");
        Contact contact2 = new Contact("12345", "John", "Smith", "0987654321", "456 Oak Street");

        service.addContact(contact1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    // Test deleting a contact
    @Test
    public void testDeleteContact() {

        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "Justin", "Florida", "1234567890", "123 Main Street");

        service.addContact(contact);
        service.deleteContact("12345");

        assertNull(service.getContact("12345"));
    }

    // Test updating first name
    @Test
    public void testUpdateFirstName() {

        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "Justin", "Florida", "1234567890", "123 Main Street");

        service.addContact(contact);
        service.updateFirstName("12345", "Carlo");

        assertEquals("Carlo", service.getContact("12345").getFirstName());
    }

    // Test updating last name
    @Test
    public void testUpdateLastName() {

        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "Justin", "Florida", "1234567890", "123 Main Street");

        service.addContact(contact);
        service.updateLastName("12345", "Test");

        assertEquals("Test", service.getContact("12345").getLastName());
    }

    // Test updating phone number
    @Test
    public void testUpdatePhone() {

        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "Justin", "Florida", "1234567890", "123 Main Street");

        service.addContact(contact);
        service.updatePhone("12345", "0987654321");

        assertEquals("0987654321", service.getContact("12345").getPhone());
    }

    // Test updating address
    @Test
    public void testUpdateAddress() {

        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "Justin", "Florida", "1234567890", "123 Main Street");

        service.addContact(contact);
        service.updateAddress("12345", "456 Oak Street");

        assertEquals("456 Oak Street", service.getContact("12345").getAddress());
    }
}