/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.orient.course.dao.impl;

import az.orient.course.dao.DBHelper;
import az.orient.course.dao.LoginUserDao;
import az.orient.course.model.LoginUser;
import az.orient.course.model.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Lenovo
 */
public class LoginUserDaoImpl implements LoginUserDao {

    @Override
    public LoginUser login(String username, String password) throws Exception {
        LoginUser loginUser = new LoginUser();
        String sql = "SELECT LU.ID,LU.USERNAME,LU.NAME,LU.SURNAMER,R.ID R_ID,R.ROLE_NAME FROM LOGIN_USER LU\n"
                + "INNER JOIN ROLE R ON LU.ROLE_ID = R.ID\n"
                + "WHERE LU.ACTIVE =1 AND LU.USERNAME = ? AND LU.PASSWORD = ?";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                loginUser.setId(rs.getLong("ID"));
                loginUser.setUsername(rs.getString("USERNAME"));
                //loginUser.setPassword(rs.getString("PASSWORD"));
                loginUser.setName(rs.getString("NAME"));
                loginUser.setSurname(rs.getString("SURNAMER"));
                Role role = new Role();
                role.setId(rs.getLong("R_ID"));
                role.setRoleName(rs.getString("ROLE_NAME"));
                loginUser.setRole(role);

            }
            else{
                loginUser = null;
            }
        }

        return loginUser;

    }

}
