package com.quinn.crm.post.domain;


import com.quinn.crm.department.domain.Department;
import com.quinn.crm.staff.domain.Staff;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Post {


    public Post(String postId, String postName) {
        this.postId = postId;
        this.postName = postName;
    }

    private String postId;
    private String postName;
    private Department dept;
    private Set<Staff> staffs = new HashSet<>();

    public Post() {
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Set<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId='" + postId + '\'' +
                ", postName='" + postName + '\'';
    }
}
