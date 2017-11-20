package com.quinn.crm.department.service;

import com.quinn.crm.department.domain.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> findAllDepartment();

    void addOrEditDepartment(Department dept);

    Department findDeptById(String deptId);

}
