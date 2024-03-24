package org.example;

import java.time.LocalDate;
public class Test {
    public static void main(String[] args) {
        TeamLead teamLead = new TeamLead("Can", "Can", LocalDate.of(1985, 1, 1), "Female");
        Department department = new Department(teamLead);
        Male maleEmployee = new Male("Deniz", "Deniz", LocalDate.of(1982, 1, 1));
        Female femaleEmployee = new Female("Sevi", "Sevi", LocalDate.of(1982, 1, 1));
        department.addEmployee(maleEmployee);
        department.addEmployee(femaleEmployee);
        department.showTeamLead();
        department.listEmployees();
        department.addAssignment("ABC Projesi / Görev 101");
        department.addAssignment("ABC Projesi / Görev 102");
        department.listAssignments();
        department.markAssignmentComplete("ABC Projesi / Görev 101");
        department.listAssignments();
    }
}
