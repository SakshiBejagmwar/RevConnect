package com.revconnect.app;

import com.revconnect.service.*;
import java.util.Scanner;

public class RevConnectApp {

    static int loggedInUserId = -1;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        AuthService authService = new AuthService();
        PostService postService = new PostService();
        SocialService socialService = new SocialService();

        // Welcome banner
        System.out.println("     🌟 Welcome to RevConnect 🌟    ");
        System.out.println("------------------------------------------");

        while (true) {
            System.out.println("""
                📌 MENU
                1️.  Register
                2️.  Login
                3️.  Create Post
                4️.  Like Post
                5️.  Comment
                6️.  Follow User
                7️.  View Notifications
                8️.  Exit
                """);

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1 -> {
                    System.out.println("\n📝 REGISTER NEW USER");
                    System.out.print("📧 Email: ");
                    String email = sc.nextLine();
                    System.out.print("🔑 Password: ");
                    String password = sc.nextLine();
                    System.out.print("🧑 Name: ");
                    String name = sc.nextLine();
                    System.out.print("📝 Bio: ");
                    String bio = sc.nextLine();
                    System.out.print("👤 User Type (PERSONAL/BUSINESS/CREATOR): ");
                    String type = sc.nextLine();
                    System.out.print("📍 Location: ");
                    String location = sc.nextLine();

                    authService.register(email, password, name, bio, type, location);
                    System.out.println("-------------------------------------------------");
                    System.out.println("✅ Registered successfully!\n");
                }

                case 2 -> {
                    System.out.println("\n🔐 LOGIN");
                    System.out.print("📧 Email: ");
                    String email = sc.nextLine();
                    System.out.print("🔑 Password: ");
                    String password = sc.nextLine();

                    loggedInUserId = authService.login(email, password);
                    System.out.println("-------------------------------------------------");
                    System.out.println(
                            loggedInUserId != -1 ? "✔ Login successful! Welcome back!" : "❌ Invalid credentials"
                    );
                    
                    System.out.println("-------------------------------------------------");
                }

                case 3 -> {
                    System.out.println("\n📝 CREATE POST");
                    System.out.print("✏️ Post content: ");
                    postService.createPost(loggedInUserId, sc.nextLine());
                    System.out.println("-------------------------------------------------");
                    System.out.println("✅ Post created successfully!\n");
                }

                case 4 -> {
                    System.out.println("\n❤️ LIKE POST");
                    System.out.print("🆔 Post ID: ");
                    int postId = sc.nextInt();
                    System.out.print("🧑 Post Owner ID: ");
                    int ownerId = sc.nextInt();
                    sc.nextLine();

                    socialService.likePost(loggedInUserId, postId, ownerId);
                    System.out.println("-------------------------------------------------");
                    System.out.println("👍 Post liked!\n");
                }

                case 5 -> {
                    System.out.println("\n💬 COMMENT ON POST");
                    System.out.print("🆔 Post ID: ");
                    int postId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("✏️ Comment: ");
                    String comment = sc.nextLine();
                    System.out.print("🧑 Post Owner ID: ");
                    int ownerId = sc.nextInt();
                    sc.nextLine();

                    socialService.comment(postId, loggedInUserId, comment, ownerId);
                    System.out.println("-------------------------------------------------");
                    System.out.println("✅ Comment added!\n");
                }

                case 6 -> {
                    System.out.println("\n👥 FOLLOW USER");
                    System.out.print("🆔 User ID to follow: ");
                    socialService.follow(loggedInUserId, sc.nextInt());
                    sc.nextLine();
                    System.out.println("-------------------------------------------------");
                    System.out.println("✅ You are now following the user!\n");
                }

                case 7 -> {
                    System.out.println("\n🔔 NOTIFICATIONS");
                    socialService.viewNotifications(loggedInUserId);
                    System.out.println();
                }

                case 8 -> {
                    System.out.println("\n👋 Thank you for using RevConnect! Goodbye!");
                    System.exit(0);
                }

                default -> System.out.println("❌ Invalid choice. Please try again.\n");
 
            }
            sc.close();
        }
    }
}
