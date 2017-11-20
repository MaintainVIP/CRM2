package com.quinn.crm.staff.service.impl;

import com.quinn.crm.staff.dao.StaffDao;
import com.quinn.crm.staff.domain.Staff;
import com.quinn.crm.staff.service.StaffService;
import org.apache.commons.lang3.StringUtils;

import java.util.List;


public class StaffServiceImpl implements StaffService{

    private StaffDao staffDao;
    @Override
    public List findAll() {
        return staffDao.findAll();
    }
    //从数据库查询登录信息
    @Override
    public Staff login(String loginName,String loginPwd) {
        //System.out.println(staff.getLoginName()+staff.getLoginPwd());
        return staffDao.login(loginName,loginPwd);
    }
    //添加员工
    @Override
    public void addStaff(Staff staff) {

        staffDao.addStaff(staff);
    }
    //查询员工信息
    @Override
    public List findStaffById(String staffId) {
        List<Staff> staffs = staffDao.findStaffById(staffId);
        return staffs;
    }

    //修改员工信息
    @Override
    public void editStaffs(Staff staff) {
        staffDao.editStaff(staff);

    }

    @Override
    public List<Staff> findStaffByStaffName(String staffName,String postId,String deptId) {
        //如果staffName 为空 部门和职务有一个不为空 那就要赋一个不存在的值
        //如果staffName不为空 那就可以正常查
        //如果全部为空,那么就可以正常查


        if ((StringUtils.isNotBlank(postId)|StringUtils.isNotBlank(deptId))){
            staffName = "这是一个乱码";
        }
        return staffDao.findStaffByStaffName(staffName, postId, deptId);

    }
    //用登录名查询员工
    @Override
    public List<Staff> findStaffByLoginName(String loginStaff) {
        return staffDao.findStaffByLoginName(loginStaff);
    }
    //修改密码
    @Override
    public void editPassword(Staff staff) {
        staffDao.editPassword(staff);

    }


    public StaffDao getStaffDao() {
        return staffDao;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
