package com.benjaminbutton.controller;

import com.alibaba.fastjson.JSONObject;
import com.benjaminbutton.bean.TblUserRecord;
import com.benjaminbutton.json.Common;
import com.benjaminbutton.json.Permission;
import com.benjaminbutton.json.Permissions;
import com.benjaminbutton.json.UserInfo;
import com.benjaminbutton.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


/**
 * @author WWX
 * @description
 * @date 2020-06-24 20:24
 * @modified By
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/auth/2step-code")
    public boolean step_code2(){
        System.out.println("step_code2");
        return true;
    }

    @RequestMapping("/auth/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session){
        TblUserRecord tblUserRecord = loginService.login(username, password);
        tblUserRecord.setToken(tblUserRecord.getUserName());
        session.setAttribute("userRecord", tblUserRecord);
        Common common = new Common(tblUserRecord);
        return JSONObject.toJSONString(common);
    }

    @RequestMapping("/user/info")
    public String userInfo(HttpSession session){
        TblUserRecord userRecord = (TblUserRecord) session.getAttribute("userRecord");
        String[] rolePrivileges = userRecord.getTblRole().getRolePrivileges().split("-");
        Permissions permissions = new Permissions();
        List<Permission> permissionList = new ArrayList<>();
        for(String rolePrivilege : rolePrivileges){
            permissionList.add(new Permission(rolePrivilege));
        }
        permissions.setPermissions(permissionList);
        UserInfo userInfo = new UserInfo(userRecord.getUserName(), permissions);
        Common common = new Common(userInfo);
        return JSONObject.toJSONString(common);
    }

    @RequestMapping("/auth/logout")
    public void logout(HttpSession session){
        session.invalidate();
        return;
    }
}
