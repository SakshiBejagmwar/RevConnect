package com.revconnect.dao;


import com.revconnect.config.DBConfig;
import java.sql.*;


public class LikeDAO {
public void likePost(int userId, int postId) throws Exception {
String sql = "INSERT INTO likes(user_id, post_id) VALUES (?,?)";
try (Connection con = DBConfig.getConnection();
PreparedStatement ps = con.prepareStatement(sql)) {
ps.setInt(1, userId);
ps.setInt(2, postId);
ps.executeUpdate();
}
}


public void unlikePost(int userId, int postId) throws Exception {
String sql = "DELETE FROM likes WHERE user_id=? AND post_id=?";
try (Connection con = DBConfig.getConnection();
PreparedStatement ps = con.prepareStatement(sql)) {
ps.setInt(1, userId);
ps.setInt(2, postId);
ps.executeUpdate();
}
}
}