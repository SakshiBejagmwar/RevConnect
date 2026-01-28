package com.revconnect.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public void registerUser(String email, String password, String name,
                             String bio, String userType, String location) throws Exception {

        String sql = "INSERT INTO users(email,password,name,bio,user_type,location) VALUES(?,?,?,?,?,?)";
        PreparedStatement ps = ConnectionDAO.getConnection().prepareStatement(sql);

        ps.setString(1, email);
        ps.setString(2, password);
        ps.setString(3, name);
        ps.setString(4, bio);
        ps.setString(5, userType);
        ps.setString(6, location);

        ps.executeUpdate();
    }

    public int validateLogin(String email, String password) throws Exception {

        String sql = "SELECT id FROM users WHERE email=? AND password=?";
        PreparedStatement ps = ConnectionDAO.getConnection().prepareStatement(sql);

        ps.setString(1, email);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt("id");
        }
        return -1;
    }
}
