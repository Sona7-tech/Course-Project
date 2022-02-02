/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.orient.course.service;

import az.orient.course.model.LoginUser;

/**
 *
 * @author Lenovo
 */
public interface LoginUserService {
    
    LoginUser login(String username, String password) throws Exception;
}
