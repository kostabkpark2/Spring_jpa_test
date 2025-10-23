package org.example.spring_jpa_test.service;

import org.example.spring_jpa_test.domain.Employee;
import org.example.spring_jpa_test.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

  @Test
  void updateEmployee() {
    // given
    Employee employee = new Employee("20250001", "홍길동", 1, "20250101", 500);
    employeeService.createEmployee(employee);
    // when
    boolean b = employeeService.updateEmployeeInfo(employee.getEmpId(), 10);
    // then
    assertThat(b).isTrue();
    assertThat(employeeService.selectEmployee("20250001").getSalary()).isEqualTo(510);
  }

  @Test
  void otherQueries() {
    // given
    // when
    List<Employee> emps = employeeRepository.findAllByEmpNameStartingWith("김");
    // then
    assertThat(emps.size()).isEqualTo(2);
  }
}