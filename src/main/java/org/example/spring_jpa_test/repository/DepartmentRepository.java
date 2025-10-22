package org.example.spring_jpa_test.repository;

import org.example.spring_jpa_test.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
