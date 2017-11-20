package com.quinn.crm.department.service.impl;

import com.quinn.crm.department.dao.DepartmentDao;
import com.quinn.crm.department.domain.Department;
import com.quinn.crm.department.service.DepartmentService;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService{

    private DepartmentDao departmentDao;

    @Override
    public List<Department> findAllDepartment() {
        return departmentDao.findAllDepartments();
    }

    @Override
    public void addOrEditDepartment(Department dept) {

        if (StringUtils.isBlank(dept.getDeptId())){
            dept.setDeptId(null);
        }
        departmentDao.addOrEditDepartments(dept);
    }

    @Override
    public Department findDeptById(String deptId) {
        return departmentDao.findDeptById(deptId);
    }



    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }
}
