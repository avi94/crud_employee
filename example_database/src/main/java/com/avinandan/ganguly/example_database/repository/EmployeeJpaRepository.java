package com.avinandan.ganguly.example_database.repository;

import com.avinandan.ganguly.example_database.bean.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Long> {
}
