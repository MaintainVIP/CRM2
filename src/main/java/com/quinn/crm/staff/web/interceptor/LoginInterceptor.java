package com.quinn.crm.staff.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.quinn.crm.staff.domain.Staff;
import org.apache.struts2.ServletActionContext;

/**
 * 登录拦截器
 */
public class LoginInterceptor extends MethodFilterInterceptor {

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception{
        Staff staff = (Staff) ServletActionContext.getRequest().getSession().getAttribute("staff1");
        System.out.println(staff +"LoginInterceptor________________________________________________________");
        if(staff != null){
            return actionInvocation.invoke();
        }else{
            return "input";
        }
    }
}

