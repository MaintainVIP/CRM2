package com.quinn.crm.staff.service;


import com.quinn.crm.staff.domain.Staff;

import java.util.List;

public interface StaffService {


    List findAll();

    Staff login(String loginName,String loginPwd);

    void addStaff(Staff staff);

    //查询员工信息
    List findStaffById(String staffId);
    //修改员工信息
    void editStaffs(Staff staff);
    //高级查询
    List<Staff> findStaffByStaffName(String staffName,String postId,String deptId);

    //用用户名查询员工信息
    List<Staff> findStaffByLoginName(String loginStaff);

    void editPassword(Staff staff);
}
