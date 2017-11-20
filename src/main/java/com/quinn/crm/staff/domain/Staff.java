package com.quinn.crm.staff.domain;


import com.quinn.crm.post.domain.Post;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Staff {

    private String staffId;
    private String loginName;
    private String loginPwd;
    private String staffName;
    private String gender;
    private Date onDutyDate;
    private Post post;

    //修改密码,姑且不用
    private String oldPwd;
    private String newPwd;
    private String reNewPwd;



    public Staff() {
    }

    public Staff(String staffId, String loginName, String loginPwd, String staffName, String gender, Date onDutyDate,Post post) {
        this.staffId = staffId;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.staffName = staffName;
        this.gender = gender;
        this.onDutyDate = onDutyDate;
        this.post = post;
    }

    public Staff(String staffId, String loginName, String loginPwd, String staffName, String gender, Date onDutyDate, Post post, String oldPwd, String newPwd, String reNewPwd) {
        this.staffId = staffId;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.staffName = staffName;
        this.gender = gender;
        this.onDutyDate = onDutyDate;
        this.post = post;
        this.oldPwd = oldPwd;
        this.newPwd = newPwd;
        this.reNewPwd = reNewPwd;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId='" + staffId + '\'' +
                ", loginName='" + loginName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", staffName='" + staffName + '\'' +
                ", gender='" + gender + '\'' +
                ", onDutyDate=" + onDutyDate +
                '}';
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getOnDutyDate() {
        return onDutyDate;
    }

    public void setOnDutyDate(Date onDutyDate) {
        this.onDutyDate = onDutyDate;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }



    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }
    public String getOldPwd() {
        return oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getReNewPwd() {
        return reNewPwd;
    }

    public void setReNewPwd(String reNewPwd) {
        this.reNewPwd = reNewPwd;
    }
}
