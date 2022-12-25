package com.swanws.EmpMgt.dao;

import org.springframework.stereotype.Repository;

import com.swanws.EmpMgt.model.Employee;
import com.swanws.EmpMgt.model.Employees;

@Repository
public class EmployeeDAO {
	private static Employees list = new Employees();

	static {
		list.getEmployeeList().add(new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com"));
		list.getEmployeeList().add(new Employee(2, "Alex", "Kolenchiskey", "abc@gmail.com"));
		list.getEmployeeList().add(new Employee(3, "David", "Kameron", "titanic@gmail.com"));
	}

	public Employees getAllEmployees() {
		return list;
	}

	public void addEmployee(Employee employee) {
		list.getEmployeeList().add(employee);
	}

	public Employee getEmployeeById(int id) {
		for (Employee emp : list.getEmployeeList()) {
			if (emp.getId() == id) {
				return emp;
			}
		}

		return null;
	}

	public Employee getEmployeeByFirstName(String name) {
		for (Employee emp : list.getEmployeeList()) {
			if (emp.getFirstName().equals(name)) {
				return emp;
			}
		}
		return null;
	}

	public Employee getEmployeeByLastName(String name) {
		for (Employee emp : list.getEmployeeList()) {
			if (emp.getLastName().equals(name)) {
				return emp;
			}
		}
		return null;
	}

	public Employee getEmployeeByFirstNameAndLastName(String fname, String lname) {
		if (!fname.equals(null) && !lname.equals(null)) {	
			for (Employee emp : list.getEmployeeList()) {
				if (emp.getFirstName().equals(fname) && emp.getLastName().equals(lname)) {
					System.out.println(emp);
					return emp;
				}
			}
		} 
		return null;
	}

}
