package org.example.spring_jpa_test.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

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
  private int deptId;
  @Column(length = 8)
  private String joinDate;
  private long salary;
}
