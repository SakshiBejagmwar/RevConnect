package com.revconnect;

import com.revconnect.service.AuthService;
import org.junit.jupiter.api.Test;

public class AuthServiceTest {

    @Test
    void registerUserTest() throws Exception {

        AuthService auth = new AuthService();

        auth.register(
                "test2@mail.com",
                "1234",
                "Test User",
                "JUnit testing user",
                "PERSONAL",
                "Mumbai"
        );
    }
}
