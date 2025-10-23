package org.example.spring_jpa_test.domain;

import jakarta.persistence.*;
import lombok.*;
import org.example.spring_jpa_test.dto.EmployeeDto;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
  @Id
  @Column(length = 8)
  private String empId;
  @Column(length = 30)
  private String empName;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="dept_id")
  private Department department;
  @Column(length = 8)
  private String joinDate;
  private long salary;

  public EmployeeDto toEmpDto() {
    return new EmployeeDto(empId, empName, department.getDeptId());
  }
}
