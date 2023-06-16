package telran.people.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import java.util.function.Predicate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.people.Employee;
import telran.people.Company;




class CompanyTest {
	private Company company;
@BeforeEach
        void setUp() throws Exception {
	 Employee[] employees = {
             new Employee(1, "John Doe", 1990, "Sales", 5000),
             new Employee(2, "Jane Smith", 1985, "Marketing", 6000),
             new Employee(3, "Mike Johnson", 1992, "Sales", 5500),
             new Employee(4, "Emily Brown", 1988, "HR", 4500),
             new Employee(5, "Alex Wilson", 1995, "IT", 7000)
     };
        	company=new Company(employees);
        }

    @Test
    void getAllEmployeesTest() {
        Employee[] expected = {
                new Employee(1, "John Doe", 1990, "Sales", 5000),
                new Employee(2, "Jane Smith", 1985, "Marketing", 6000),
                new Employee(3, "Mike Johnson", 1992, "Sales", 5500),
                new Employee(4, "Emily Brown", 1988, "HR", 4500),
                new Employee(5, "Alex Wilson", 1995, "IT", 7000)
        };
        Employee[] actual =company.getAllEmployees(Comparator.naturalOrder());

       assertArrayEquals(expected, actual);
    }

    @Test
    void GetEmployeesByAgeTest() {
        Employee[] expected = {
                new Employee(2, "Jane Smith", 1985, "Marketing", 6000),
                new Employee(4, "Emily Brown", 1988, "HR", 4500)
        };
        Employee[] actual = company.getEmployeesByAge(1985, 1988);

        assertArrayEquals(expected, actual);
    }

    @Test
    void GetEmployeesBySalaryTest() {
        Employee[] expected = {
        		new Employee(4, "Emily Brown", 1988, "HR", 4500),
        		new Employee(1, "John Doe", 1990, "Sales", 5000),
                new Employee(3, "Mike Johnson", 1992, "Sales", 5500),

        };
        Employee[] actual = company.getEmployeesBySalary(4000, 5500);
        assertArrayEquals(expected, actual);
    }

    @Test
    void GetEmployeesByDepartmentTest() {
        Employee[] expected = {
                new Employee(1, "John Doe", 1990, "Sales", 5000),
                new Employee(3, "Mike Johnson", 1992, "Sales", 5500)
        };
        Employee[] actual = company.getEmployeesByDepartment("Sales",Comparator.naturalOrder());

       assertArrayEquals(expected, actual);
    }

    @Test
    void AddEmployeeTest() {
        Employee newEmployee = new Employee(6, "Sarah Davis", 1993, "Marketing", 5500);
        boolean isAdded = company.addEmployee(newEmployee);
        assertTrue(isAdded);
        Employee newEmployee1 = new Employee(6, "Sarah Davis", 1993, "Marketing", 5500);
        boolean isAdded1 = company.addEmployee(newEmployee1);
        assertFalse(isAdded1);

        
        
    }
    @Test
    void testRemoveEmployeesIf() {
        Predicate<Employee> predicate = emp -> emp.getSalary() < 5500;
        boolean isRemoved = company.removeEmployeesIf(predicate);
        assertTrue(isRemoved);
        
    }

	}


