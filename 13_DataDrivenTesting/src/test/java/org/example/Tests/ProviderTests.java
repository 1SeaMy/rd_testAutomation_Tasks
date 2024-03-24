package org.example.Tests;

import org.example.Department;
import org.example.Employees;
import org.testng.Assert;
import org.testng.annotations.*;

public class ProviderTests {
    Long sysTime;
    int a=0;

    @BeforeClass
    public void setUpClass() {
        System.out.println("Testler başladı... "+ System.currentTimeMillis());
        sysTime= System.currentTimeMillis();
    }

    @AfterClass
    public void tearDownClass() {
        sysTime=System.currentTimeMillis()-sysTime;
        System.out.println(System.currentTimeMillis() + " Testler sonlandı... ");
        System.out.println("Testlerin süresi : "+ sysTime);
    }

    @BeforeMethod
    public void setUpMethod() {
        a+=1;
        System.out.print(a + ". test start...");
    }

    @AfterMethod
    public void tearDownMethod() {
        System.out.println(a+ ". test end.");
    }

    @DataProvider(name = "employeeData")
    public Object[][] employeeData() {
        return new Object[][] {
                {1, "Muhasebe Bölümü", 1, "Ayşe", "Can", "Muhasebe Müdürü", 25, 55000},
                {2, "Satış Bölümü", 2, "Ali", "Kara", "Satış Uzmanı", 28, 45000},
        };
    }

    @Test(dataProvider = "employeeData", groups = "Employees")
    public void testEmployees(int depId, String depName, int empId, String empName, String empSurname, String empPosition, int empWorkedDays, double empSalary) {
        Employees employee = new Employees(depId, depName, empId, empName, empSurname, empPosition, empWorkedDays, empSalary);

        Assert.assertEquals(employee.getDepId(), depId);
        Assert.assertEquals(employee.getDepName(), depName);
        Assert.assertEquals(employee.getEmpId(), empId);
        Assert.assertEquals(employee.getEmpName(), empName);
        Assert.assertEquals(employee.getEmpSurname(), empSurname);
        Assert.assertEquals(employee.getEmpPosition(), empPosition);
        Assert.assertEquals(employee.getEmpWorkedDays(), empWorkedDays);

        double expectedSalary = calculateExpectedSalary(empWorkedDays, empSalary);
        Assert.assertEquals(employee.getEmpSalary(), expectedSalary);
    }
    private double calculateExpectedSalary(int empWorkedDays, double baseSalary) {
        if (empWorkedDays > 25 && empWorkedDays < 32) {
            return baseSalary + (empWorkedDays - 25) * 1000;
        } else {
            return baseSalary;
        }
    }
    @DataProvider(name = "departmentData")
    public Object[][] departmentData() {
        return new Object[][] {
                {1, "Muhasebe Bölümü"},
                {2, "Satış Bölümü"},
        };
    }

    @Test(dataProvider = "departmentData", groups = "Department")
    public void testDepartment(int depId, String depName) {
        Department department = new Department(depId, depName);

        Assert.assertEquals(department.getDepId(), depId);
        Assert.assertEquals(department.getDepName(), depName);
    }
}
