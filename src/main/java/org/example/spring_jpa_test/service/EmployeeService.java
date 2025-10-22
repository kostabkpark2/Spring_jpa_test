package org.example.spring_jpa_test.service;

import lombok.RequiredArgsConstructor;
import org.example.spring_jpa_test.domain.Employee;
import org.example.spring_jpa_test.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {
  private final EmployeeRepository employeeRepository;

  public void createEmployee(Employee employee) {
    employeeRepository.save(employee);
  }
}
