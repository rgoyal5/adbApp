package com.verizon.restapi;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.model.Employee;
import com.verizon.service.EmployeeService;



@RestController
@CrossOrigin
@RequestMapping("/Employees")
public class EmployeeApi {

	@Autowired
	private EmployeeService service;

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return new ResponseEntity<>(service.getAllEmployees(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long EmployeeId) {

		ResponseEntity<Employee> resp;
		Employee c = service.getEmployeeById(EmployeeId);
		if (c == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(c, HttpStatus.OK);
		return resp;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployeeAction(@PathVariable("id") long EmployeeId) {
		ResponseEntity<Void> resp = null;
		boolean isDeleted = service.deleteEmployee(EmployeeId);
		if (!isDeleted)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(HttpStatus.OK);
		return resp;
	}

	@PostMapping
	public ResponseEntity<Employee> addEmployeeAction(@RequestBody Employee Employee) {
		ResponseEntity<Employee> resp = null;
		if (service.existsByEmailId(Employee.getEmailId())) {
			resp = new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
		}
		if (service.existsByMobileNumber(Employee.getMobileNumber())) {
			resp = new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
		}

		if (resp == null) {
			Employee c = service.addEmployee(Employee);
			if (c == null)
				resp = new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<Employee>(c, HttpStatus.OK);
		}
		return resp;
	}

	@PutMapping
	public ResponseEntity<Employee> updateEmployeeAction(@RequestBody Employee Employee) {
		ResponseEntity<Employee> resp = null;
		Employee c = service.getEmployeeById(Employee.getEmpId());
		if (!Employee.getEmailId().equals(c.getEmailId())) {
			if (service.existsByEmailId(Employee.getEmailId())) {
				resp = new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
			}
		}
		if (!Employee.getMobileNumber().equals(c.getMobileNumber())) {
			if (service.existsByMobileNumber(Employee.getMobileNumber())) {
				resp = new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
			}
		}
		if (resp == null) {
			c = service.updateEmployee(Employee);
			if (c == null)
				resp = new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<Employee>(c, HttpStatus.OK);
		}
		return resp;
	}

	@GetMapping("/{field}/{srhValue}")
	public ResponseEntity<List<Employee>> getAllEmployees(@PathVariable("field") String fieldBy,
			@PathVariable("srhValue") String searchValue) {
	//	List<Employee> results = null;
		ResponseEntity<List<Employee>> resp = null;
		switch (fieldBy) {
		case "mobileNumber":
			Employee cbyMobNum = service.findByMobileNumber(searchValue);
			if (cbyMobNum != null) {
				resp = new ResponseEntity<List<Employee>>(Collections.singletonList(cbyMobNum),HttpStatus.OK);
			}
			else
			{
				resp = new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
			}
			break;
		case "emailId":
			Employee cbyEmail = service.findByEmailId(searchValue);
			if (cbyEmail != null) {
				resp = new ResponseEntity<List<Employee>>(Collections.singletonList(cbyEmail),HttpStatus.OK);
			}
			else
				resp = new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
			break;
		case "lastName":
			List<Employee> results = service.findAllByLastName(searchValue);
			if(results !=null && results.size()!=0){
				resp = new ResponseEntity<List<Employee>>(results,HttpStatus.OK);
			}
			else
			{
				resp = new ResponseEntity<List<Employee>>(results,HttpStatus.NOT_FOUND);
			}
			break;
			default:
				resp = new ResponseEntity<List<Employee>>(HttpStatus.BAD_REQUEST);
				break;
		}
		return resp;
	}
}