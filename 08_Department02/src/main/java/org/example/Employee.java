package org.example;

import java.time.LocalDate;
import java.time.Period;
abstract class Employee implements Retireable {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String gender;

    public Employee(String firstName, String lastName, LocalDate birthDate, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public int calculateRemainingYearsToRetirement() {
        return Math.max(0, Period.between(LocalDate.now(), getBirthDate().plusYears(calculateRetirementAge())).getYears());
    }
}

