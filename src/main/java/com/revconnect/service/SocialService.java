package com.revconnect.service;

import com.revconnect.dao.NotificationDAO;
import com.revconnect.dao.SocialDAO;

import java.util.List;

public class SocialService {

    private SocialDAO socialDAO = new SocialDAO();
    private NotificationDAO notificationDAO = new NotificationDAO();

    public void likePost(int userId, int postId, int ownerId) throws Exception {
        socialDAO.likePost(userId, postId);
        notificationDAO.addNotification(ownerId, "Your post was liked");
    }

    public void comment(int postId, int userId, String comment, int ownerId) throws Exception {
        socialDAO.commentPost(postId, userId, comment);
        notificationDAO.addNotification(ownerId, "New comment on your post");
    }

    public void follow(int followerId, int followingId) throws Exception {
        socialDAO.followUser(followerId, followingId);
        notificationDAO.addNotification(followingId, "You have a new follower");
    }

    public void viewNotifications(int userId) throws Exception {
        List<String> notifications = notificationDAO.getNotifications(userId);

        if (notifications.isEmpty()) {
            System.out.println("No notifications");
        } else {
            notifications.forEach(System.out::println);
        }
    }
}
