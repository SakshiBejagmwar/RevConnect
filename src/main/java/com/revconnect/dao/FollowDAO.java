package com.revconnect.dao;


import com.revconnect.config.DBConfig;
import java.sql.*;


public class FollowDAO {
public void follow(int follower, int following) throws Exception {
String sql = "INSERT INTO follows VALUES (?,?)";
try (Connection con = DBConfig.getConnection();
PreparedStatement ps = con.prepareStatement(sql)) {
ps.setInt(1, follower);
ps.setInt(2, following);
ps.executeUpdate();
}
}


public void unfollow(int follower, int following) throws Exception {
String sql = "DELETE FROM follows WHERE follower_id=? AND following_id=?";
try (Connection con = DBConfig.getConnection();
PreparedStatement ps = con.prepareStatement(sql)) {
ps.setInt(1, follower);
ps.setInt(2, following);
ps.executeUpdate();
}
}
}