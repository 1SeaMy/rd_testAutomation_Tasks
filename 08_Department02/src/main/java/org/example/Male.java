package org.example;

import java.time.LocalDate;
class Male extends Employee {
    public Male(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate, "Male");
    }

    @Override
    public int calculateRetirementAge() {
        return "Male".equalsIgnoreCase(getGender()) ? 65 : 60;
    }
}
