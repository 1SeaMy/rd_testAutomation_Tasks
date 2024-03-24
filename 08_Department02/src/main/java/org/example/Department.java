package org.example;

import java.util.ArrayList;
import java.util.List;
class Department {
    private TeamLead teamLead;
    private List<Employee> employeeList;
    private List<String> assignmentList;

    public Department(TeamLead teamLead) {
        this.teamLead = teamLead;
        this.employeeList = new ArrayList<>();
        this.assignmentList = new ArrayList<>();
    }

    public void changeTeamLead(TeamLead newTeamLead) {
        this.teamLead = newTeamLead;
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employeeList.remove(employee);
    }

    public void changeEmployee(Employee oldEmployee, Employee newEmployee) {
        int index = employeeList.indexOf(oldEmployee);
        if (index != -1) {
            employeeList.set(index, newEmployee);
        }
    }
    public void listEmployees() {
        System.out.println("---------Çalişan Listesi :");
        for (Employee employee : employeeList) {
            System.out.println(employee.getFirstName() + " " + employee.getLastName()+ " / Emekliliğe kalan yıl : " +employee.calculateRemainingYearsToRetirement());
        }
    }
    public void showTeamLead() {
        System.out.println("---------Takım Lideri :");
        System.out.println(teamLead.getFirstName() + " "+ teamLead.getLastName() + " / Emekliliğe kalan yıl : " + teamLead.calculateRemainingYearsToRetirement());
    }

    public void addAssignment(String assignment) {
        assignmentList.add(assignment);
    }

    public void markAssignmentComplete(String assignment) {
        System.out.println("---------Tamamlanan Görevler :");
        assignmentList.remove(assignment);
        System.out.println(assignment);
    }

    public void listAssignments() {
        System.out.println("---------Görev Listesi :");
        for (String assignment : assignmentList) {
            System.out.println(assignment);
        }
    }
}
