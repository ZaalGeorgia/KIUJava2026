package badsmells;

/*
 * Smell: Long Parameter List
 *
 * The method takes many related values directly instead of receiving a few
 * meaningful objects such as address or guardian contact information.
 *
 * Proposed Refactorings:
 * - Introduce parameter objects for address and guardian contact.
 * - Preserve whole object when the caller already has a richer object.
 */
public class LongParameterListExample {

    public String registerStudent(String firstName, String lastName,
                                  ContactInfo contactInfo,
                                  Address address,
                                  GuardianContact guardianContact,
                                  String program, int startYear,
                                  boolean scholarship) {
        return firstName + " " + lastName + " -> " + program + " (" + startYear + "), guardian="
                + guardianContact.getName() + ", scholarship=" + scholarship + ", address="
                + address.getCity() + ", " + address.getStreet() + ", " + address.getZipCode()
                + ", contact=" + contactInfo.getEmail() + "/" + contactInfo.getPhone()
                + ", guardianPhone=" + guardianContact.getPhone();
    }

    public void clientCode() {
        ContactInfo contactInfo = new ContactInfo("nino@example.com", "+995-555-000-001");
        Address address = new Address("Tbilisi", "Rustaveli Ave 10", "0108");
        GuardianContact guardianContact = new GuardianContact("Maka Beridze", "+995-555-000-999");

        String summary = registerStudent(
                "Nino",
                "Beridze",
                contactInfo,
                address,
                guardianContact,
                "Computer Science",
                2026,
                true
        );
        System.out.println(summary);
    }

    private static class ContactInfo {
        private final String email;
        private final String phone;

        public ContactInfo(String email, String phone) {
            this.email = email;
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public String getPhone() {
            return phone;
        }
    }

    private static class Address {
        private final String city;
        private final String street;
        private final String zipCode;

        public Address(String city, String street, String zipCode) {
            this.city = city;
            this.street = street;
            this.zipCode = zipCode;
        }

        public String getCity() {
            return city;
        }

        public String getStreet() {
            return street;
        }

        public String getZipCode() {
            return zipCode;
        }
    }

    private static class GuardianContact {
        private final String name;
        private final String phone;

        public GuardianContact(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }
    }
}
