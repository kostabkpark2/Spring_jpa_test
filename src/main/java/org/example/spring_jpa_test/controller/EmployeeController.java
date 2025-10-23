package org.example.spring_jpa_test.controller;

import lombok.RequiredArgsConstructor;
import org.example.spring_jpa_test.dto.EmployeeDto;
import org.example.spring_jpa_test.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

  @PostMapping("/create")
  @ResponseBody
  public String createEmployee(@RequestBody EmployeeDto employeeDto) {
    employeeService.createEmployee(employeeDto);
    return "사원정보 생성 완료";
  }

  @GetMapping("/list/{deptId}")
  @ResponseBody
  public
}
