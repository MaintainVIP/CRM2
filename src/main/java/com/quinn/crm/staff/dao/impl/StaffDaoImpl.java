package com.quinn.crm.staff.dao.impl;


import com.quinn.crm.staff.dao.StaffDao;
import com.quinn.crm.staff.domain.Staff;
import org.apache.commons.lang3.StringUtils;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {

    private List<Staff> staffs;


    @Override
    public List<Staff> findAll() {

        return getHibernateTemplate().loadAll(Staff.class);
    }

    @Override
    public Staff login(String loginName, String loginPwd) {

        System.out.println("用户名" + loginName);
        System.out.println("密码" + loginPwd);
        String sql = "from Staff where loginName=? and loginPwd=?";
        staffs = (List<Staff>) getHibernateTemplate().find(sql, loginName, loginPwd);
        if (staffs.size() == 1) {
            return staffs.get(0);
        }
        return null;
    }

    @Override
    public void addStaff(Staff staff) {

        getHibernateTemplate().save(staff);
    }

    @Override
    public Staff editStaff(Staff staff) {
        getHibernateTemplate().update(staff);

        return staff;
    }

    @Override
    public List<Staff> findStaffById(String staffId) {

        String sql = "from Staff where staffId=?";
        staffs = (List<Staff>) getHibernateTemplate().find(sql, staffId);

        return staffs;
    }

    @Override
    public List<Staff> findStaffByStaffName(String staffName, String postId, String deptId) {


        String sql = "from Staff where staffName like? or post.postId=? or post.dept.deptId=?";
        staffs = (List<Staff>) getHibernateTemplate().find(sql, "%" + staffName + "%", postId, deptId);

        return staffs;
    }

    //用用户名查询员工信息
    @Override
    public List<Staff> findStaffByLoginName(String loginStaff) {

        String sql = "from Staff where loginName=?";
        staffs = (List<Staff>) getHibernateTemplate().find(sql, loginStaff);
        System.out.println(staffs);
        return staffs;
    }

    //修改密码
    @Override
    public void editPassword(Staff staff) {
        getHibernateTemplate().update(staff);
    }


    @Override
    public List find(Object o) {
        return null;
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(Object o) {

    }
}
