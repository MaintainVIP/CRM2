package com.quinn.crm.utils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.lang.reflect.ParameterizedType;



public class BaseAction<M,S> extends ActionSupport implements ModelDriven<M>{

    public static final String LOGIN_KEY = "user_uuid";

    private M model;
    protected S service;

    public BaseAction() {
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        Class clazz = (Class) type.getActualTypeArguments()[0];
        try {
            model = (M) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void sessionPut(String key, Object value){
        ActionContext.getContext().getSession().put(key, value);
    }

    @Override
    public M getModel() {
        return model;
    }

    public void setModel(M model) {
        this.model = model;
    }

    public void setService(S service) {
        this.service = service;
    }
}
