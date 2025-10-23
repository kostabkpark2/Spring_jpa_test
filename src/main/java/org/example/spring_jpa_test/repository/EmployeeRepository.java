package org.example.spring_jpa_test.repository;

import org.example.spring_jpa_test.domain.Employee;
import org.example.spring_jpa_test.dto.EmployeeDeptDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
  List<Employee> findAllByEmpNameLike(String empName);
  List<Employee> findAllByEmpNameStartingWith(String familyName);
  //Employee findByEmpNameEqualsAndDeptIdEquals(String empName, int deptId);
  int countBySalaryBetween(long salary1, long salary2);

  @Query("select new org.example.spring_jpa_test.dto.EmployeeDeptDto(e.empId, e.empName, e.department.deptName) " +
      "from Employee e " +
      "left outer join Department d " +
      "on e.department.deptId = d.deptId " +
      "where d.deptId = :dept_id")
  List<EmployeeDeptDto> findEmployeesAndDepartments(@Param("dept_id") int deptId);

}

