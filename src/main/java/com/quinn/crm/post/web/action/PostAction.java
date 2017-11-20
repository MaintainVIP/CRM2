package com.quinn.crm.post.web.action;


import com.quinn.crm.department.dao.impl.DepartmentDaoImpl;
import com.quinn.crm.department.domain.Department;
import com.quinn.crm.department.service.DepartmentService;
import com.quinn.crm.department.service.impl.DepartmentServiceImpl;
import com.quinn.crm.post.domain.Post;
import com.quinn.crm.post.service.PostService;
import com.quinn.crm.utils.BaseAction;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class PostAction extends BaseAction<Post, PostService> {

    private List<Post> posts;
    private List<Department> departments;
    private DepartmentService departmentService;
    private String deptId;

    //职务列表
    public String listPost() {
        posts = service.findAll();
        return SUCCESS;
    }
    //根据部门ID查找对应的所有职务
    public String findPostByDeptId() {
        posts = service.findPostByDeptId(deptId);
        return SUCCESS;
    }
    //真正的添加职务或修改职务
    public String addPost() {
        if (StringUtils.isBlank(getModel().getPostName()) || StringUtils.isBlank(getModel().getDept().getDeptId())) {
            return ERROR;
        }
        service.addOrEditPost(getModel());
        return SUCCESS;
    }
    //添加或修改职务
    public String addOrEditPost() {
        departments = departmentService.findAllDepartment();
        return SUCCESS;

    }


    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }


    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public DepartmentService getDepartmentService() {
        return departmentService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
}

