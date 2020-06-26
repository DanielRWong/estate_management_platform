package com.benjaminbutton.service;

import com.benjaminbutton.bean.TblUserRecord;
import com.benjaminbutton.mapper.TblUserRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author WWX
 * @description
 * @date 2020-06-24 22:35
 * @modified By
 */

@Service
public class LoginService {
    @Autowired
    private TblUserRecordMapper tblUserRecordMapper;

    public TblUserRecord login(String username, String password){
        return tblUserRecordMapper.login(username,password);
    }
}
