package com.newproject.dummyproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newproject.dummyproject.entities.employee_details;

public interface emp_repo extends JpaRepository<employee_details, Integer> {

}
