package org.example.spring_jpa_test.domain;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Repository;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Department {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int deptId;
  @Column(length = 20)
  private String deptName;
}
