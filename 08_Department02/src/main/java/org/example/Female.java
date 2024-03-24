package org.example;

import java.time.LocalDate;
class Female extends Employee{
    public Female(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate, "Female");
    }

    @Override
    public int calculateRetirementAge() {
        return "Male".equalsIgnoreCase(getGender()) ? 65 : 60;
    }
}
