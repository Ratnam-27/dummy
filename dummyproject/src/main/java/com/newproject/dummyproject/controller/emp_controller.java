package com.newproject.dummyproject.controller;

import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.newproject.dummyproject.entities.employee_details;
import com.newproject.dummyproject.services.emp_service;

@RestController
@RequestMapping("/api/employee")
public class emp_controller {

	@Autowired
    emp_service service;
	
	@PostMapping("/")
	public ResponseEntity<employee_details> create(@RequestBody employee_details obj)
	{
		employee_details emp1 = this.service.add(obj);
		return new ResponseEntity<>(emp1,HttpStatus.CREATED);
	}
	
	@PutMapping("/{empid}")
	public ResponseEntity<employee_details> update(@RequestBody employee_details obj2, @PathVariable Integer empid)
	{
		employee_details updatedemp= this.service.update(obj2, empid);
		return  ResponseEntity.ok(updatedemp);
	}
	
	@DeleteMapping("/{empid}")
	public ResponseEntity<?> delete(@PathVariable Integer empid)
	{
		this.service.delete(empid);
		return ResponseEntity.ok(Map.of("message","Employee terminated"));
	}
	
	@GetMapping("/")
	public ResponseEntity<List<employee_details>> getAll()
	{
		return ResponseEntity.ok(this.service.getAll());
	}
	
	@GetMapping("/{empid}")
	public ResponseEntity<employee_details> get(@PathVariable Integer empid)
	{
		return ResponseEntity.ok(this.service.get(empid));
	}
	
}
