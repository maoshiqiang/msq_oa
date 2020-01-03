package com.imooc.oa.controller;

import com.imooc.oa.biz.GlobalBiz;
import com.imooc.oa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller("globalController")//声明控制器

public class GloablController {
    @Autowired
    private GlobalBiz globalBiz;

    //去登录
    public String toLogin(){
        return "login";
    }

    //登录
    @RequestMapping("/login")
    public String login(HttpSession session,@RequestParam String sn, @RequestParam String password){
        Employee employee=globalBiz.login(sn,password);
        //如果登陆失败-则重新登录
        if(employee==null){
            return "redirect:to_login";
        }
        //登录成功-将信息保存在session中
            session.setAttribute("employee",employee);
            return "redirect:self";
    }

    //登录成功-跳转至个人信息页面
    @RequestMapping("/self")
    public String self(){
        return "self";
    }


    //退出
    @RequestMapping("/quit")
    public String login(HttpSession session){
        session.setAttribute("employee",null);
        return "redirect:to_login";//退出-返回登录界面
    }


    //去修改密码
    @RequestMapping("/to_change_password")
    public String toChangePassword(){
        return "change_password";
    }


    //修改密码
    @RequestMapping("/change_password")
    public String changePassword(HttpSession session, @RequestParam String old, @RequestParam String new1 ,@RequestParam String new2){
        Employee employee = (Employee)session.getAttribute("employee");
        if(employee.getPassword().equals(old)){
            if(new1.equals(new2)){
                employee.setPassword(new1);
                globalBiz.changePassword(employee);
                return "redirect:self";//修改成功返回个人信息
            }
        }
        return "redirect:to_change_password";//原密码不匹配-重新修改
    }

}
