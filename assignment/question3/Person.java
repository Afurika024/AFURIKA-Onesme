package question3;

import java.time.LocalDate;

class Person {
    private String personId;
    private String fullName;
    private LocalDate dob;
    private String email;
    private String phone;

    public Person(String personId, String fullName, LocalDate dob, String email, String phone) {
        this.personId = personId;
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        validatePerson();
    }

    private void validatePerson() {
        if (fullName.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            throw new IllegalArgumentException("Personal details must not be empty.");
        }
        if (dob.isAfter(LocalDate.now().minusYears(18))) {
            throw new IllegalArgumentException("Policyholder must be at least 18 years old.");
        }
    }

    public String getFullName() {
        return fullName;
    }

    public String getPersonId() {
        return personId;
    }

    @Override
    public String toString() {
        return fullName + " (" + email + ", " + phone + ")";
    }
}

