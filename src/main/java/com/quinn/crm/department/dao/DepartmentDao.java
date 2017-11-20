package com.quinn.crm.department.dao;
import com.quinn.crm.department.domain.Department;

import java.util.List;


public interface DepartmentDao {

    List<Department> findAllDepartments();


    void addOrEditDepartments(Department dept);


    Department findDeptById(String deptId);


}
