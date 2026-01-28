package com.revconnect.service;


import com.revconnect.config.DBConfig;
import java.sql.*;


public class PostService {
public void createPost(int userId, String content) throws Exception {
String sql = "INSERT INTO posts(user_id,content) VALUES(?,?)";
try (Connection con = DBConfig.getConnection();
PreparedStatement ps = con.prepareStatement(sql)) {
ps.setInt(1, userId);
ps.setString(2, content);
ps.executeUpdate();
}
}
}