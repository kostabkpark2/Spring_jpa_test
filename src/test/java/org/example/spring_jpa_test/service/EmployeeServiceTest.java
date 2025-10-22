package org.example.spring_jpa_test.service;

import org.example.spring_jpa_test.domain.Employee;
import org.example.spring_jpa_test.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@Transactional
class EmployeeServiceTest {
  @Autowired
  private EmployeeRepository employeeRepository;
  @Autowired
  private EmployeeService employeeService;

  @Test
  void createEmployee() {
    // given
    Employee employee = new Employee("20250001", "홍길동", 1, "20250101", 500);
    // when
    employeeService.createEmployee(employee);
    // then
    assertThat(employeeRepository.findById("20250001").isPresent()).isEqualTo(true);
  }
}