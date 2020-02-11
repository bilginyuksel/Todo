package com.bilginyuksel.todo.Preparation;

import com.bilginyuksel.todo.model.User;
import org.springframework.lang.Nullable;

public class UserTestPreparation {


    private String usernameTemplate = "test-%d";
    private String passwordtemplate = "%d-tset";
    private String mailTemplate = "test-%d@testmail.com";

    private int queue = 1;

    private User user1;
    private User user2;
    private User user3;
    private boolean firstUserEnabled = false;
    private boolean secondUserEnabled = false;
    private boolean thirdUserEnabled = false;

    public UserTestPreparation(){

    }

    public void setUser1(@Nullable User user1) {

        if (queue != 1) return;

        firstUserEnabled = true;
        this.user1 = user1 == null?createUserWithStringFormatter():user1;
        queue++;
    }

    public void setUser2(@Nullable User user2) {
        if(user1 == null) return;
        if(queue != 2) return;

        secondUserEnabled = true;
        this.user2 = user2==null?createUserWithStringFormatter():user2;
        queue++;
    }

    public void setUser3(@Nullable User user3) {
        if(user2==null) return;
        if(queue!=3) return;

        thirdUserEnabled = true;
        this.user3 = user3 == null?createUserWithStringFormatter():user3;
        queue++;
    }

    private User createUserWithStringFormatter(){
        return new User(
                String.format(usernameTemplate,queue),
                String.format(passwordtemplate,queue),
                String.format(mailTemplate,queue)
        );
    }

    public User getUser1() {
        return user1;
    }
    public User getUser2() {
        return user2;
    }
    public User getUser3() {
        return user3;
    }
    public boolean isFirstUserEnabled() {
        return firstUserEnabled;
    }
    public boolean isSecondUserEnabled() {
        return secondUserEnabled;
    }
    public boolean isThirdUserEnabled() {
        return thirdUserEnabled;
    }


}
