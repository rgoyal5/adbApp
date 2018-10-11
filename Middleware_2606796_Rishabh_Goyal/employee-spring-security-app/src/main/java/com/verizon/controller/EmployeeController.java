package com.verizon.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.verizon.model.Employee;
import com.verizon.model.Gender;
import com.verizon.service.employeeService;

@Controller
public class EmployeeController {
	@Autowired
	private employeeService EmployeeService;

	@GetMapping("/employeeList")
	public ModelAndView handleEmployeeList() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("elistPage");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
			mv.addObject("currentUserName", auth.getName());
		}
		mv.addObject("employees", EmployeeService.getAllEmployees());
		return mv;
	}

	@GetMapping("/errors")
	public String errorPage() {
		return "Invalid Credentials For this operation";
	}

	@GetMapping("/addEmployee")
	public ModelAndView handleNewEmployee() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addEmployeePage");
		mv.addObject("Employee", new Employee());
		mv.addObject("genders", Gender.values());
		mv.addObject("possibDept", new String[] { "It", "Cloud", "Support", "Testing" });
		return mv;
	}

	@PostMapping("/addEmployee")
	public ModelAndView handleAddEmployee(@ModelAttribute("Employee") @Valid Employee Employee,
			BindingResult validationResults) {
		ModelAndView mv = new ModelAndView();
		boolean flag = false;
		Employee c = EmployeeService.getEmployeeById(Employee.getEmpId());
		if (c != null) {
			if (!Employee.getEmailId().equals(c.getEmailId())) {
				if (EmployeeService.existsByEmailId(Employee.getEmailId())) {
					validationResults.rejectValue("emailId", "error.Employee", "Email Id Already Exists");
				}
			}
			if (!Employee.getMobileNumber().equals(c.getMobileNumber())) {
				if (EmployeeService.existsByMobileNumber(Employee.getMobileNumber())) {
					validationResults.rejectValue("mobileNumber", "error.Employee", "Mobile Number Already Exists");
				}
			}
			flag = true;
		} 
		else {
			if (EmployeeService.existsByEmailId(Employee.getEmailId())) {
				validationResults.rejectValue("emailId", "error.Employee", "Email Id Already Exists");
			}
			if (EmployeeService.existsByMobileNumber(Employee.getMobileNumber())) {
				validationResults.rejectValue("mobileNumber", "error.Employee", "Mobile Number Already Exists");
			}

		}
		if (validationResults.hasErrors()) {
			mv.setViewName("addEmployeePage");
			mv.addObject("Employee", Employee);
			mv.addObject("genders", Gender.values());
			mv.addObject("possibDept", new String[] { "It", "Cloud", "Support", "Testing" });
		}
		// System.out.println(Employee.getEmpId());
		if (!flag)
			EmployeeService.addEmployee(Employee);
		else
			EmployeeService.updateEmployee(Employee);
		mv.setViewName("redirect:/employeeList");
		return mv;
	}

	@GetMapping("/editEmp")
	public ModelAndView editBookAction(@RequestParam("empId") int empId) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addEmployeePage");
		mv.addObject("Employee", EmployeeService.getEmployeeById(empId));
		mv.addObject("genders", Gender.values());
		mv.addObject("possibDept", new String[] { "It", "Cloud", "Support", "Testing" });
		return mv;
	}

	@GetMapping("/deleteEmp")
	public String deleteEmpAction(@RequestParam("empId") int empId) {
		EmployeeService.deleteEmployee(empId);
		return "redirect:/EmployeeList";
	}

	@GetMapping("/searchEmployee")
	public String handleSearchEmployee() {
		return "searchPage";
	}

	@PostMapping("/searchEmployee")
	public ModelAndView handleDoSearchEmployee(@RequestParam("srhValue") String searchValue,
			@RequestParam("field") String byField) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("searchPage");
		mv.addObject("pageTitle", "Results for " + byField + "= " + searchValue);
		switch (byField) {
		case "mobile":
			mv.addObject("result", EmployeeService.findByMobileNumber(searchValue));
			break;
		case "email":
			mv.addObject("result", EmployeeService.findByEmailId(searchValue));
			break;
		case "lnm":
			mv.addObject("results", EmployeeService.findAllByLastName(searchValue));
			break;
		case "dp":
			mv.addObject("results", EmployeeService.findAllByDept(searchValue));
			break;
		case "dob":
			mv.addObject("results", EmployeeService.findAllByDateOfBirth(LocalDate.parse(searchValue)));
			break;
		}
		return mv;
	}

}