import java.util.HashMap;
import java.util.Map;

public class ContactService {

    // Store contacts using contact ID
    private final Map<String, Contact> contacts = new HashMap<>();

    // Add a contact
    public void addContact(Contact contact) {

        // Check for duplicate contact ID
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }

        contacts.put(contact.getContactId(), contact);
    }

    // Delete contact by ID
    public void deleteContact(String contactId) {

        // Remove contact
        contacts.remove(contactId);
    }

    // Update first name
    public void updateFirstName(String contactId, String firstName) {

        Contact contact = contacts.get(contactId);

        if (contact != null) {
            contact.setFirstName(firstName);
        }
    }

    // Update last name
    public void updateLastName(String contactId, String lastName) {

        Contact contact = contacts.get(contactId);

        if (contact != null) {
            contact.setLastName(lastName);
        }
    }

    // Update phone number
    public void updatePhone(String contactId, String phone) {

        Contact contact = contacts.get(contactId);

        if (contact != null) {
            contact.setPhone(phone);
        }
    }

    // Update address
    public void updateAddress(String contactId, String address) {

        Contact contact = contacts.get(contactId);

        if (contact != null) {
            contact.setAddress(address);
        }
    }

    // Return contact by ID
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}