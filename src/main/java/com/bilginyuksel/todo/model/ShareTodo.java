package com.bilginyuksel.todo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ShareTodo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    private User sharedTo;
    @OneToOne
    private Todo todo;
    private String token;
    private Date sharedDate;
    private Date expireDate;
    private boolean enable;
    private String url;


    public ShareTodo(){

    }

    public ShareTodo(User sharedTo, Todo todo){
        this.sharedTo = sharedTo;
        this.todo = todo;
        this.enable = true;
        this.sharedDate = new Date();
    }


    public void setUrl(String token) {
        this.token = token;
        this.url = "api/todo/share-"+ token;
    }

    public void setSharing(User sharedTo) {
        this.sharedTo = sharedTo;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public Todo getTodo() {
        return todo;
    }

    public User getSharedTo() {
        return sharedTo;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public Date getSharedDate() {
        return sharedDate;
    }

    public boolean isEnable() {
        return enable;
    }

    public String getUrl() {
        return url;
    }
}
