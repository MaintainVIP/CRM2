package com.quinn.crm.staff.dao;


import com.quinn.crm.staff.domain.Staff;
import com.quinn.crm.utils.BaseDao;

import java.util.List;

public interface StaffDao extends BaseDao {

        List<Staff> findAll();

        Staff login(String loginName,String loginPwd);

        void addStaff(Staff staff);

        Staff editStaff(Staff staff);

        List<Staff> findStaffById(String staffId);

        List<Staff> findStaffByStaffName(String staffName,String postId,String deptId);
        //用用户名查询员工
        List<Staff> findStaffByLoginName(String loginStaff);

        void editPassword(Staff staff);
}
