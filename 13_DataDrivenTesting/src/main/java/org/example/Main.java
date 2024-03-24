package org.example;

public class Main {
    public static void main(String[] args) {
        Employees employees01 = new Employees(1,"Muhasebe Bölümü", 1,"Ayşe", "Can", "Muhasebe Müdürü", 25,55000);
        employees01.displayData();
        Employees employees02=new Employees(2,"Ali", "Kara", "Muhasebe Uzmanı", 28,45000);
        employees02.displayEmpData();
    }
}