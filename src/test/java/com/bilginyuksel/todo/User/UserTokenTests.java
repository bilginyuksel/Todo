package com.bilginyuksel.todo.User;

import com.bilginyuksel.todo.exception.UserLoginException;
import com.bilginyuksel.todo.model.OAuth;
import com.bilginyuksel.todo.repository.OAuthRepository;
import com.bilginyuksel.todo.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
public class UserTokenTests {

    private final String username = "bilginyuksel";
    private final String password = "123456";
    private final String expectedToken = "c3b25925-6eda-49fa-b988-596d4f00ba24";

    @Autowired private UserService userService;
    @Autowired private OAuthRepository authRepository;

    @Test
    @Rollback
    void checkAlreadyLoggedUserToken(){

        try {
            String oAuthToken = userService.login(username,password);
            System.out.println("OAuth Token From Login : "+oAuthToken);
            System.out.println("Expected OAuth Token : "+expectedToken);
            Assert.assertEquals(expectedToken, oAuthToken);
        } catch (UserLoginException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Transactional
    @Rollback
    void checkIsTokenDisabledAfterLogout(){
        userService.logout("c3b25925-6eda-49fa-b988-596d4f00ba24");
        Optional<OAuth> oAuth = authRepository.findByToken("c3b25925-6eda-49fa-b988-596d4f00ba24");

        System.out.println("OAuth Token = "+expectedToken);
        System.out.println("Current OAuth token status = "+ true);
        System.out.println("After the logout token status = "+oAuth.get().isEnabled());
        Assert.assertNotNull(oAuth.get());
        Assert.assertEquals(oAuth.get().isEnabled(), false);
    }


}
