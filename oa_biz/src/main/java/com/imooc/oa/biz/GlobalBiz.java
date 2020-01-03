package com.imooc.oa.biz;

import com.imooc.oa.entity.Employee;

public interface GlobalBiz {
    Employee login(String sn, String password);//登录功能：员工账号和密码
    Void changePassword(Employee employee);//修改改密码,并且声明实现对象

}
