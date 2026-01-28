package com.revconnect.dao;

import java.sql.PreparedStatement;

public class SocialDAO {

    public void likePost(int userId, int postId) throws Exception {
        String sql = "INSERT INTO likes(user_id, post_id) VALUES (?, ?)";
        PreparedStatement ps = ConnectionDAO.getConnection().prepareStatement(sql);
        ps.setInt(1, userId);
        ps.setInt(2, postId);
        ps.executeUpdate();
    }

    public void commentPost(int postId, int userId, String comment) throws Exception {
        String sql = "INSERT INTO comments(post_id, user_id, comment) VALUES (?, ?, ?)";
        PreparedStatement ps = ConnectionDAO.getConnection().prepareStatement(sql);
        ps.setInt(1, postId);
        ps.setInt(2, userId);
        ps.setString(3, comment);
        ps.executeUpdate();
    }

    public void followUser(int followerId, int followingId) throws Exception {
        String sql = "INSERT INTO follows(follower_id, following_id) VALUES (?, ?)";
        PreparedStatement ps = ConnectionDAO.getConnection().prepareStatement(sql);
        ps.setInt(1, followerId);
        ps.setInt(2, followingId);
        ps.executeUpdate();
    }
}
