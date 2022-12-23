package com.swanws.EmpMgt.dao;

import org.springframework.stereotype.Repository;

import com.swanws.EmpMgt.model.Employee;
import com.swanws.EmpMgt.model.Employees;

@Repository
public class EmployeeDAO {
	private static Employees list = new Employees();
	
	static
    {
        list.getEmployeeList().add(new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com"));
        list.getEmployeeList().add(new Employee(2, "Alex", "Kolenchiskey", "abc@gmail.com"));
        list.getEmployeeList().add(new Employee(3, "David", "Kameron", "titanic@gmail.com"));
    }
	
	 public Employees getAllEmployees() 
	    {
	        return list;
	    }
	     
	    public void addEmployee(Employee employee) {
	        list.getEmployeeList().add(employee);
	    }
}
