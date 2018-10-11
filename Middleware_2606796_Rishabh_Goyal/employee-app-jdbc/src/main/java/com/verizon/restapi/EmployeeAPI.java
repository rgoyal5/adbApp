package com.verizon.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.verizon.bsa.model.Employee;
import com.verizon.bsa.service.*;



@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeeAPI {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public ResponseEntity<List<Employee>> listEmployeesAction(){
		return new ResponseEntity<List<Employee>>
				(employeeService.getAll(),HttpStatus.OK);
	}
	@GetMapping("/{eid}")
	public ResponseEntity<Employee> getEmployeeAction(@PathVariable("eid")int eid){
		ResponseEntity<Employee> resp=null;
		Employee b = employeeService.getEmployeeById(eid);
		if(b==null)
				resp =  new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		else
			resp =  new ResponseEntity<Employee>(b,HttpStatus.OK);
		return resp;
	}
	@DeleteMapping("/{eid}")
	public ResponseEntity<Void> deleteEmployeeAction(@PathVariable("eid")int eid){
		ResponseEntity<Void> resp=null;
		boolean isDeleted = employeeService.deleteEmployeeById(eid);
		if(!isDeleted)
				resp =  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp =  new ResponseEntity<>(HttpStatus.OK);
		return resp;
	}
	@PostMapping
	public ResponseEntity<Employee> addEmployeeAction(@RequestBody Employee emp){
		ResponseEntity<Employee> resp = null;
		emp = employeeService.add(emp);
		if(emp!=null)
			resp = new ResponseEntity<>(emp,HttpStatus.OK);
		else
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return resp;
	}
	
	@PutMapping
	public ResponseEntity<Employee> updateBookAction(@RequestBody Employee emp){
		ResponseEntity<Employee> resp = null;
		if(employeeService.getEmployeeById(emp.getEid())==null){
			resp =  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else
		{
			emp = employeeService.update(emp);
			if(emp!=null)
					resp = new ResponseEntity<>(emp,HttpStatus.OK);
			else
				resp = new ResponseEntity<>(emp,HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
}
