package com.verizon.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.model.Employee;

@Repository
public interface empRepository extends JpaRepository<Employee, Long> {

}
