package org.example;

public class Employees extends Department{
    private int empId;
    private String empName;
    private String empSurname;
    private String empPosition;
    private int empWorkedDays;
    private double empSalary;

    public Employees() {
    }

    public Employees(int empId, String empName, String empSurname, String empPosition, int empWorkedDays, double empSalary) {
        this.empId = empId;
        this.empName = empName;
        this.empSurname = empSurname;
        this.empPosition = empPosition;
        this.empWorkedDays = empWorkedDays;
        if ((this.empWorkedDays>25) && (this.empWorkedDays<32)) {
            this.empSalary = empSalary+(this.empWorkedDays-25)*1000;
        } else {
            this.empSalary = empSalary;
        }
    }

    public Employees(int depId, String depName, int empId, String empName, String empSurname, String empPosition, int empWorkedDays, double empSalary) {
        super(depId, depName);
        this.empId = empId;
        this.empName = empName;
        this.empSurname = empSurname;
        this.empPosition = empPosition;
        this.empWorkedDays = empWorkedDays;
        if ((this.empWorkedDays>25) && (this.empWorkedDays<32)) {
            this.empSalary = empSalary+(this.empWorkedDays-25)*1000;
        } else {
            this.empSalary = empSalary;
        }
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpSurname() {
        return empSurname;
    }

    public void setEmpSurname(String empSurname) {
        this.empSurname = empSurname;
    }

    public String getEmpPosition() {
        return empPosition;
    }

    public void setEmpPosition(String empPosition) {
        this.empPosition = empPosition;
    }

    public int getEmpWorkedDays() {
        return empWorkedDays;
    }

    public void setEmpWorkedDays(int empWorkedDays) {
        this.empWorkedDays = empWorkedDays;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }

    @Override
    public void displayData() {
        super.displayData();
        System.out.println("Personel Id : " + empId);
        System.out.println("Personel Adı : " + empName);
        System.out.println("Personel Soyadı : " + empSurname);
        System.out.println("Personel Pozisyonu : " + empPosition);
        System.out.println("Personelin Çalıştığı Gün :" + empWorkedDays);
        System.out.println("Personel Maaşı : " + empSalary);
    }

    public void displayEmpData() {
        System.out.println("-----PERSONEL BİLGİLERİ-----");
        System.out.println("Personel Id : " + empId);
        System.out.println("Personel Adı : " + empName);
        System.out.println("Personel Soyadı : " + empSurname);
        System.out.println("Personel Pozisyonu : " + empPosition);
        System.out.println("Personelin Çalıştığı Gün :" + empWorkedDays);
        System.out.println("Personel Maaşı : " + empSalary);
    }
}