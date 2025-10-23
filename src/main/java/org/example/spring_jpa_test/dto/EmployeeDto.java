package org.example.spring_jpa_test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeDto {
  private String empId;
  private String empName;
  private int deptId;
}
