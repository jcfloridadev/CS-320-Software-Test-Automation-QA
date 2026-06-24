public class Contact {

    // Contact fields
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor
    public Contact(String contactId, String firstName, String lastName,
                   String phone, String address) {

        // Validate contact ID
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }

        this.contactId = contactId;

        // Set contact information
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    // Getter for contact ID
    public String getContactId() {
        return contactId;
    }

    // Getter for first name
    public String getFirstName() {
        return firstName;
    }

    // Getter for last name
    public String getLastName() {
        return lastName;
    }

    // Getter for phone number
    public String getPhone() {
        return phone;
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Setter for first name
    public void setFirstName(String firstName) {

        // Validate first name
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }

        this.firstName = firstName;
    }

    // Setter for last name
    public void setLastName(String lastName) {

        // Validate last name
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }

        this.lastName = lastName;
    }

    // Setter for phone number
    public void setPhone(String phone) {

        // Validate phone number
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone number");
        }

        this.phone = phone;
    }

    // Setter for address
    public void setAddress(String address) {

        // Validate address
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }

        this.address = address;
    }
}