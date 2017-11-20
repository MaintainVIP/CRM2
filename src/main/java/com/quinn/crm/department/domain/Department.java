package com.quinn.crm.department.domain;


import com.quinn.crm.post.domain.Post;
import com.quinn.crm.staff.domain.Staff;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Department{

    private String deptId;
    private String deptName;

    private Set<Post> posts = new HashSet<>();
    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }


    @Override
    public String toString() {
        return "Department{" +
                "deptId='" + deptId + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }

    public Department() {
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Set<Post> getPosts() {
        return posts;
    }


}
