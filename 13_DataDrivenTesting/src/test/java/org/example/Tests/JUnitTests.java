package org.example.Tests;

import org.example.Department;
import org.example.Employees;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class JUnitTests {
    Long sysTime;
    @Before
    public void before(){
        System.out.println("Test başladı... "+ System.currentTimeMillis());
        sysTime= System.currentTimeMillis();
    }
    @After
    public void tearDown(){
        sysTime=System.currentTimeMillis()-sysTime;
        System.out.println(System.currentTimeMillis() + " Test sonlandı... ");
        System.out.println("Test süresi : "+ sysTime);
    }
    @Test
    public void testEmployees() {
        Employees employee = new Employees(1, "Muhasebe", 1, "Ayşe", "Can", "Muhasebe Müdürü", 25, 55000);
        assertEquals(1, employee.getDepId());
        assertEquals("Muhasebe", employee.getDepName());
        assertEquals(1, employee.getEmpId());
        assertEquals("Ayşe", employee.getEmpName());
        assertEquals("Can", employee.getEmpSurname());
        assertEquals("Muhasebe Müdürü", employee.getEmpPosition());
        assertEquals(25, employee.getEmpWorkedDays());
        assertEquals(55000, employee.getEmpSalary(), 0.01);
    }

    @Test
    public void testDepartment() {
        Department department = new Department(1, "Muhasebe");
        assertEquals(1, department.getDepId());
        assertEquals("Muhasebe", department.getDepName());
    }
}
