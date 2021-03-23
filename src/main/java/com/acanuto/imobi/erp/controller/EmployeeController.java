package com.acanuto.imobi.erp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acanuto.imobi.erp.dto.EmployeeDTO;
import com.acanuto.imobi.erp.model.Employee;
import com.acanuto.imobi.erp.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody EmployeeDTO employeeDTO) {
		try {
			return new ResponseEntity<Employee>(service.save(employeeDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RuntimeException("Erro: " + System.lineSeparator() + e.getMessage());
		}
	}

	@GetMapping()
	@ResponseStatus(value = HttpStatus.OK)
	public List<Employee> getAll() {
		List<Employee> employees = new ArrayList<>();
		service.getAll().forEach(employees::add);
		return employees;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@RequestParam long id) {
		Optional<Employee> emp = service.getById(id);
		if (emp.isPresent()) {
			return new ResponseEntity<Optional<Employee>>(emp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{cpf}")
	public ResponseEntity<?> getByCpf(@RequestParam String cpf) {
		Optional<Employee> emp = service.getByCpf(cpf);
		if (emp.isPresent()) {
			return new ResponseEntity<Optional<Employee>>(emp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{username}")
	public ResponseEntity<?> getByUsername(@RequestParam String username) {
		Optional<Employee> emp = service.getByUsername(username);
		if (emp.isPresent()) {
			return new ResponseEntity<Optional<Employee>>(emp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
