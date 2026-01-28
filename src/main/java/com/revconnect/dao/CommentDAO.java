package com.revconnect.dao;


import com.revconnect.config.DBConfig;
import java.sql.*;


public class CommentDAO {
public void addComment(int postId, int userId, String comment) throws Exception {
String sql = "INSERT INTO comments(post_id,user_id,comment) VALUES (?,?,?)";
try (Connection con = DBConfig.getConnection();
PreparedStatement ps = con.prepareStatement(sql)) {
ps.setInt(1, postId);
ps.setInt(2, userId);
ps.setString(3, comment);
ps.executeUpdate();
}
}


public void deleteComment(int commentId) throws Exception {
String sql = "DELETE FROM comments WHERE id=?";
try (Connection con = DBConfig.getConnection();
PreparedStatement ps = con.prepareStatement(sql)) {
ps.setInt(1, commentId);
ps.executeUpdate();
}
}
}