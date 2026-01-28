package com.revconnect.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NotificationDAO {

    public void addNotification(int userId, String message) throws Exception {

        String sql = "INSERT INTO notifications(user_id, message) VALUES (?, ?)";
        PreparedStatement ps = ConnectionDAO.getConnection().prepareStatement(sql);

        ps.setInt(1, userId);
        ps.setString(2, message);
        ps.executeUpdate();
    }

    public List<String> getNotifications(int userId) throws Exception {

        List<String> notifications = new ArrayList<>();

        String sql = "SELECT message FROM notifications WHERE user_id=?";
        PreparedStatement ps = ConnectionDAO.getConnection().prepareStatement(sql);
        ps.setInt(1, userId);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            notifications.add(rs.getString("message"));
        }

        return notifications;
    }
}
