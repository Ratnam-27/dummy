package com.newproject.dummyproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newproject.dummyproject.entities.employee_details;
import com.newproject.dummyproject.repo.emp_repo;

@Service
public class emp_service {

	@Autowired
	emp_repo repo;
	
	public employee_details add(employee_details emp)
	{
		employee_details savedemp = this.repo.save(emp);
		return savedemp;
	}
	
	public employee_details update(employee_details emp2 , Integer id)
	{
		employee_details emp1= this.repo.findById(id).orElseThrow(()-> new RuntimeException("Employee not found"));
		
		emp1.setLocation(emp2.getLocation());
		emp1.setName(emp2.getName());
		emp1.setPhone_number(emp2.getPhone_number());
		
		employee_details updated_emp=this.repo.save(emp1);
		
		return updated_emp;
	}
	
	public void delete(Integer empid)
	{
		employee_details old  = this.repo.findById(empid).orElseThrow(()->new RuntimeException("Invalid id"));
		this.repo.delete(old);
	}
	
	public employee_details get(Integer empid)
	{
		employee_details old  = this.repo.findById(empid).orElseThrow(()->new RuntimeException("Invalid id"));
		return old;
	}
	
	public List<employee_details> getAll()
	{
		List<employee_details> list  = this.repo.findAll();
		return list;
	}
	
}
