package com.bilginyuksel.todo.model;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class OAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String token;
    private boolean enabled;

    @OneToOne
    private User user;

    private Date createDate, expireDate;

    public OAuth(){}

    public OAuth(User user){
        this.user = user;

        this.token = UUID.randomUUID().toString();
        this.enabled = true;

        this.createDate = new Date();
        // this.expireDate = new Date((new Date().getTime()+100000));
    }

    @Override
    public String toString() {
        return "OAuth{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", enabled=" + enabled +
                ", user=" + user +
                ", createDate=" + createDate +
                ", expireDate=" + expireDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public User getUser() {
        return user;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }
}
