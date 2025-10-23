package org.example.spring_jpa_test.controller;

import lombok.RequiredArgsConstructor;
import org.example.spring_jpa_test.dto.EmployeeDto;
import org.example.spring_jpa_test.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/emps")
@RequiredArgsConstructor
public class EmployeeController {
  private final EmployeeService employeeService;

  @GetMapping
  @ResponseBody
  public List<EmployeeDto> getAllEmps() {
    return employeeService.getAllEmployees();
  }
}
