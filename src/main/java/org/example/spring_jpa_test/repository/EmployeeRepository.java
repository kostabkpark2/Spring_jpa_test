package org.example.spring_jpa_test.repository;

import org.example.spring_jpa_test.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
  List<Employee> findAllByEmpNameLike(String empName);
  List<Employee> findAllByEmpNameStartingWith(String familyName);
  //Employee findByEmpNameEqualsAndDeptIdEquals(String empName, int deptId);
  int countBySalaryBetween(long salary1, long salary2);
}

