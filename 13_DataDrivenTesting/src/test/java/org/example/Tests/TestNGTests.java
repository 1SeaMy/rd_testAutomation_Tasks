package org.example.Tests;

import org.example.Config.Config;
import org.example.Department;
import org.example.Employees;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGTests {
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
    @Test (groups = "Employees")
    public void testEmployees() {
        int depId = Integer.parseInt(Config.getProperty("depId"));
        String depName = Config.getProperty("depName");
        int empId = Integer.parseInt(Config.getProperty("empId"));
        String empName = Config.getProperty("empName");
        String empSurname = Config.getProperty("empSurname");
        String empPosition = Config.getProperty("empPosition");
        int empWorkedDays = Integer.parseInt(Config.getProperty("empWorkedDays"));
        double empSalary = Double.parseDouble(Config.getProperty("empSalary"));

        Employees employee = new Employees(depId, depName, empId, empName, empSurname, empPosition, empWorkedDays, empSalary);

        Assert.assertEquals(employee.getDepId(), depId);
        Assert.assertEquals(employee.getDepName(), depName);
        Assert.assertEquals(employee.getEmpId(), empId);
        Assert.assertEquals(employee.getEmpName(), empName);
        Assert.assertEquals(employee.getEmpSurname(), empSurname);
        Assert.assertEquals(employee.getEmpPosition(), empPosition);
        Assert.assertEquals(employee.getEmpWorkedDays(), empWorkedDays);
        Assert.assertEquals(employee.getEmpSalary(), empSalary);
    }

    @Test (groups = "Department")
    public void testDepartment() {
        int depId = Integer.parseInt(Config.getProperty("depId"));
        String depName = Config.getProperty("depName");

        Department department = new Department(depId, depName);

        Assert.assertEquals(department.getDepId(), depId);
        Assert.assertEquals(department.getDepName(), depName);
    }
}
