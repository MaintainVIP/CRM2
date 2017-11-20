package com.quinn.crm.staff.web.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.quinn.crm.department.domain.Department;
import com.quinn.crm.department.service.DepartmentService;
import com.quinn.crm.department.service.impl.DepartmentServiceImpl;
import com.quinn.crm.department.web.action.DepartmentAction;
import com.quinn.crm.post.domain.Post;
import com.quinn.crm.post.service.PostService;
import com.quinn.crm.post.web.action.PostAction;
import com.quinn.crm.staff.domain.Staff;
import com.quinn.crm.staff.service.StaffService;
import com.quinn.crm.utils.BaseAction;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

public class StaffAction extends BaseAction<Staff, StaffService> {

    private List<Staff> staffs;
    private List<Department> departments;
    private DepartmentService departmentService;
    private List<Post> posts;
    private PostService postService;
    private String loginName;
    private String loginPwd;
    private String oldPwd;
    private String newPwd;
    private String reNewPwd;


    //查询全部
    public String listStaff() {
        staffs = service.findAll();
        posts = postService.findAll();
        departments = departmentService.findAllDepartment();
        return SUCCESS;
    }

    //登录
    public String login() {
        ActionContext.getContext().getApplication().put("staff", staffs);
        //从表单中获取账号密码,去数据库查是否存在//数据库查询
        Staff staff1 = service.login(getModel().getLoginName(), getModel().getLoginPwd());
        //存到session域中
        ServletActionContext.getRequest().getSession().setAttribute("staff1", staff1);
        //从session域中取出 ,这是干嘛的？
        ServletActionContext.getRequest().getSession().getAttribute("staff1");
        if (staff1 == null) {
            addFieldError("error", "对不起,您的用户名密码错误请重新登录");
            return INPUT;
        } else {
            ActionContext.getContext().getSession().put("loginStaff", staff1.getStaffName());
            return LOGIN;
        }
    }

    //验证器
    public void validateLogin() {
        super.validate();
        if (StringUtils.isBlank(getModel().getLoginName())) {
            addFieldError("loginName", "用户名不能为空");
        }
        if (StringUtils.isBlank(getModel().getLoginPwd())) {
            addFieldError("loginPwd", "密码不能为空");
        }

    }

    //进入修改密码的准备界面
    public String editPassword() {
        //修改密码的过程
        //查询登录的员工(staff)
        //查到密码之后赋值给oldPwd;甚至不需要赋值给旧密码 查出密码等待比对
        //在service进行判断 这里的oldPwd是输入框获取的
        //让用户输入原密码,新密码,新密码确认
        // 点击提交之前 比对 新密码和新密码确认是否一致
        // 点击提交之后 比对 输入的密码与原密码是否一致
        //两项全部通过 就执行单条修改语句,修改密码,并需要重新登录
        return SUCCESS;
    }

    //修改密码
    public String editLoginPassword() {

        String loginStaff = (String) ActionContext.getContext().getSession().get("loginStaff");
        staffs = service.findStaffByLoginName(loginStaff);
        Staff staff = staffs.get(0);
        if (!Objects.equals(staff.getLoginPwd(), getModel().getOldPwd())) {
            System.out.println(staff.getLoginPwd() + "," + getModel().getOldPwd());
            addActionError("原密码错误");
            System.out.println("ni是不是没走?ni是不是没走?ni是不是没走?ni是不是没走?ni是不是没走?ni是不是没走?ni是不是没走?");
            return "edit";
        } else {
            staff.setLoginPwd(getModel().getNewPwd());
            service.editPassword(staff);
            ServletActionContext.getRequest().getSession().removeAttribute("staff1");
            return SUCCESS;
        }
    }

    //修改密码验证器
    public void validateEditLoginPassword() {
        super.validate();
        String oldPwd;
        String newPwd;
        String reNewPwd;
        System.out.println("======================" + getModel().getOldPwd());
        oldPwd = getModel().getOldPwd();
        newPwd = getModel().getNewPwd();
        reNewPwd = getModel().getReNewPwd();

        if (StringUtils.isBlank(oldPwd)) {
            addFieldError("", "旧密码不能为空");
        }
        if (StringUtils.isBlank(newPwd)) {
            addFieldError("", "新密码不能为空");
        }
        if (!StringUtils.equals(reNewPwd, newPwd)) {
            addFieldError("", "新旧密码不一致");
        }

    }

    //编辑界面 跳转过去可以获取下拉菜单
    public String editStaff() {

        staffs = service.findStaffById(getModel().getStaffId());
        departments = departmentService.findAllDepartment();
        return SUCCESS;
    }

    //真正的添加员工
    public String addStaffs() {
        service.addStaff(getModel());
        return SUCCESS;
    }

    //高级查询
    public String findStaffs() {

        staffs = service.findStaffByStaffName(
                getModel().getStaffName()
                , getModel().getPost().getPostId()
                , getModel().getPost().getDept().getDeptId());
        departments = departmentService.findAllDepartment();
        posts = postService.findAll();
        return SUCCESS;
    }

    //添加界面 跳转过去可以获取下拉菜单
    public String addStaff() {
        departments = departmentService.findAllDepartment();

        return SUCCESS;
    }

    //真正的编辑员工
    public String editStaffs() {

        service.editStaffs(getModel());
        return SUCCESS;

    }
    //重新登录

    public String loginAgain() {

        ServletActionContext.getRequest().getSession().removeAttribute("staff1");

        return SUCCESS;
    }


    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public List<Department> getDepartments() {
        return departments;
    }


    public DepartmentService getDepartmentService() {
        return departmentService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {

        this.postService = postService;
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

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }
}
