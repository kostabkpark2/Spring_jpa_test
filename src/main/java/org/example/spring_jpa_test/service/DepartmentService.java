package org.example.spring_jpa_test.service;

import lombok.RequiredArgsConstructor;
import org.example.spring_jpa_test.domain.Department;
import org.example.spring_jpa_test.domain.Employee;
import org.example.spring_jpa_test.repository.DepartmentRepository;
import org.example.spring_jpa_test.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentService {
  private final DepartmentRepository departmentRepository;

  public void departmentEmployee(Department department) {

    departmentRepository.save(department);
  }

  public Department selectDepartment(int deptId) {
    Optional<Department> byId = departmentRepository.findById(deptId);
    return byId.isPresent() ? byId.get() : null;
  }

  public boolean updateDepartmentInfo(int deptId, String deptName) {
    Department department = selectDepartment(deptId);
    if( department != null) {
      department.setDeptName(deptName);
      departmentRepository.save(department);
      return true;
    }
    return false;
  }

//  public boolean deleteEmployee(String empId) {
//    Employee employee = selectEmployee(empId);
//    if( employee != null) {
//      employeeRepository.deleteById(empId);
//      return true;
//    }
//    return false;
//  }

  public List<Department> getAllDepartments() {
    return departmentRepository.findAll();
  }
}
