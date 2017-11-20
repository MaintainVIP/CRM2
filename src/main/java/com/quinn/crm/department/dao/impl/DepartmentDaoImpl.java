package com.quinn.crm.department.dao.impl;


import com.quinn.crm.department.dao.DepartmentDao;
import com.quinn.crm.department.domain.Department;
import org.hibernate.LockMode;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao{


    @Override
    public List<Department> findAllDepartments() {
        List<Department> departments = getHibernateTemplate().loadAll(Department.class);
        return departments;
    }

    @Override
    public void addOrEditDepartments(Department dept) {
        getHibernateTemplate().saveOrUpdate(dept);
    }

    @Override
    public Department findDeptById(String deptId) {
        return getHibernateTemplate().load(Department.class,deptId, LockMode.READ);
    }
}
