package org.example;

import java.time.LocalDate;
class TeamLead extends Employee {
    public TeamLead(String firstName, String lastName, LocalDate birthDate, String gender) {
        super(firstName, lastName, birthDate, gender);
    }

    @Override
    public int calculateRetirementAge() {
        return "Male".equalsIgnoreCase(getGender()) ? 65 : 60;
    }
}
