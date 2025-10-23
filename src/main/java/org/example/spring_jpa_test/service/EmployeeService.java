package org.example.spring_jpa_test.service;

import lombok.RequiredArgsConstructor;
import org.example.spring_jpa_test.domain.Employee;
import org.example.spring_jpa_test.dto.EmployeeDto;
import org.example.spring_jpa_test.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {
  private final EmployeeRepository employeeRepository;

  public void createEmployee(Employee employee) {
    employeeRepository.save(employee);
  }

  public Employee selectEmployee(String empId) {
    Optional<Employee> byId = employeeRepository.findById(empId);
    return byId.isPresent() ? byId.get() : null;
  }

  public boolean updateEmployeeInfo(String empId, long change) {
    Employee employee = selectEmployee(empId);
    System.out.println("before" + employee);
    if( employee != null) {
      employee.setSalary(employee.getSalary() + change);
      System.out.println("after" + employee);
      employeeRepository.save(employee);
      return true;
    }
    return false;
  }

  public boolean deleteEmployee(String empId) {
    Employee employee = selectEmployee(empId);
    if( employee != null) {
      employeeRepository.deleteById(empId);
      return true;
    }
    return false;
  }

  public List<EmployeeDto> getAllEmployees() {
    List<Employee> all = employeeRepository.findAll();
    List<EmployeeDto> empDtos = all.stream().map(Employee::toEmpDto)
        .collect(Collectors.toList());
    return empDtos;
  }
}
