package telran.people;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

import telran.people.Employee;

public class Company {
	private Employee[] employees;
    public Company(Employee[] employees) {
        this.employees = employees;
    }
	
	public Employee[] getAllEmployees(Comparator<Employee>comp) {
		 Employee[] res=Arrays.copyOf(employees, employees.length);
		 Arrays.sort(res,comp);
		 return res;
	 }
	 public Employee[] getEmployeesByPredicate(Predicate<Employee>predicate) {
		 Employee[] res=new Employee[employees.length];
		 int index=0;
		 for(int i=0;i<employees.length;i++) {
			 if(predicate.test(employees[i])) {
				 res[index++]=employees[i];
			 }
			 
		 }
		 res=Arrays.copyOf(res, index);
		 Arrays.sort(res);
		 return res;
		 
		 
	 }
	 public Employee[] getEmployeesByAge(int yearFrom,int yearTo) {
		Predicate<Employee> agePredicate=emp->emp.getBirthYear()<=yearTo&&emp.birthYear>=yearFrom;
		return getEmployeesByPredicate(agePredicate);
		}
	 public Employee[] getEmployeesBySalary(int salaryFrom,int salaryTo) {
			Predicate<Employee> salaryPredicate=emp->emp.getSalary()>=salaryFrom&&emp.getSalary()<=salaryTo;
			return getEmployeesByPredicate(salaryPredicate);
			
	 
	 
	 }
	 public Employee[] getEmployeesByDepartment(String department,Comparator<Employee>comp) {
		 Predicate<Employee>departmentPredicate=emp->emp.department==department;
		 Employee[]res=getEmployeesByPredicate(departmentPredicate);
		 Arrays.sort(res,comp);
		 return res;
	 }
	 public boolean addEmployee(Employee empl) {
		 boolean res=true;
		 for(int i=0;i<employees.length;i++) {
			 if(employees[i].id==empl.id) {
				 res=false;
			 }
			 
		 }
		 if(res) {
			 employees=Arrays.copyOf(employees, employees.length+1);
			 employees[employees.length-1]=empl;
			 
		 }
		 return res;
		
		 
	 }
	 public boolean removeEmployeesIf(Predicate<Employee>predicate) {
			int oldSize=employees.length;
			Employee [] tmp=new Employee[oldSize];
			int index=0;
			for(int i=0;i<oldSize;i++) {
				if(!predicate.test(employees[i])) {
					tmp[index++]=employees[i];
					
				}
			}
			employees=Arrays.copyOf(tmp, index);
			return oldSize>employees.length?true:false;
			
			
		}
	 public Employee getEmployee(int id) {
		 Employee res=null;
		 for(int i=0;i<employees.length;i++) {
			 if(employees[i].id==id) {
				 res=employees[i];
				 
				 
			 }
		 }
		 return res;
	 }
	 
	 
	 

}
