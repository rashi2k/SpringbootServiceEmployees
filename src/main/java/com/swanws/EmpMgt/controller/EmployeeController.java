package com.swanws.EmpMgt.controller;

import java.net.URI;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.swanws.EmpMgt.dao.EmployeeDAO;
import com.swanws.EmpMgt.model.Employee;
import com.swanws.EmpMgt.model.Employees;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeDAO employeeDao;

	@GetMapping
	public Employees getEmployees() {
		System.out.println("get All");
		 return employeeDao.getAllEmployees();
	}

	@PostMapping(path = "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
		System.out.println("Add");
		Integer id = employeeDao.getAllEmployees().getEmployeeList().size() + 1;
		employee.setId(id);

		employeeDao.addEmployee(employee);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id") int id) {
		System.out.println("by id");
		return employeeDao.getEmployeeById(id);
	}
	
	@RequestMapping(params = "fname")
	public Employee getEmployeeByFirstName(@RequestParam("fname") String fname) {
		System.out.println("by first name");
		return employeeDao.getEmployeeByFirstName(fname);
	}
	
	@RequestMapping(params = "lname")
	public Employee getEmployeeByLastName(@RequestParam("lname") String lname) {
		System.out.println("by last name");
		return employeeDao.getEmployeeByLastName(lname);
	}
	
	@RequestMapping( params = {"fname", "lname" })
	public Employee getEmployeeByFnameAndLname(@RequestParam(value="fname")  String fname, @RequestParam(value= "lname") String lname) {
		System.out.println("by fname and lname" + fname + lname);
		return employeeDao.getEmployeeByFirstNameAndLastName(fname, lname);
	}
	
}
