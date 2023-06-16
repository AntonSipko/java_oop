package telran.people;

public class Employee implements Comparable<Employee> {
	public  int id;
	public  String name;
	public  int birthYear;
	public  String department;
	public  int salary;
	public Employee(int id, String name, int birthYear, String department, int salary) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.department = department;
        this.salary = salary;
    }
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public String getDepartment() {
		return department;
	}
	public int getSalary() {
		return salary;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public boolean equals(Object empObj) {
		Employee empl=(Employee)empObj;
		return this.id==empl.id;
	}
	public int compareTo(Employee emp) {
		int id=emp.id;
		int res=0;
		if(this.id<emp.id) {
			res=-1;
			
		}else if(this.id>emp.id) {
			res=1;
		}
		return res;
	}
	
	

}
