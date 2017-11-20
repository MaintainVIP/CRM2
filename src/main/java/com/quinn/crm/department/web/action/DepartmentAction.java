package com.quinn.crm.department.web.action;


import com.quinn.crm.department.domain.Department;
import com.quinn.crm.department.service.DepartmentService;
import com.quinn.crm.utils.BaseAction;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class DepartmentAction extends BaseAction<Department,DepartmentService>{

    private List<Department> departments;
//    private Department department;

    public String listDepartment(){
        departments = service.findAllDepartment();
        return SUCCESS;
    }
    public String add(){
        service.addOrEditDepartment(getModel());
        return SUCCESS;
    }

    public String addOrEditDepartment(){
        if (StringUtils.isNotBlank(getModel().getDeptId())) {
            Department d = service.findDeptById(getModel().getDeptId());
            getModel().setDeptName(d.getDeptName());
        }
        return SUCCESS;
    }


    public List<Department> getDepartments() {
        return departments;
    }
//    public Department getDepartment() {
//        return department;
//    }


}
