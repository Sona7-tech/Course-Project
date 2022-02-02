/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.orient.course.service.impl;

import az.orient.course.dao.LoginUserDao;
import az.orient.course.model.LoginUser;
import az.orient.course.service.LoginUserService;

/**
 *
 * @author Lenovo
 */
public class LoginUserServiceImpl implements LoginUserService{
    private LoginUserDao loginUserDao;

    public LoginUserServiceImpl(LoginUserDao loginUserDao) {
        this.loginUserDao = loginUserDao;
    }

   
    
    @Override
    public LoginUser login(String username, String password) throws Exception {
        return loginUserDao.login(username, password);
    }
    
}
