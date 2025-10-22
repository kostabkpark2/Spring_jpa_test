package org.example.spring_jpa_test.repository;

import org.example.spring_jpa_test.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
