package com.bilginyuksel.todo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title; // if not create title yourself.
    private String content;
    private boolean done;
    private Date createDate, lastUpdateDate;

    private String url; // localhost:8080/tod/share-{userId}/tod-details-{todId}...

    @OneToOne
    private Category category;

    @OneToOne
    private User user;

    public Todo(){}

    public Todo(String title, String content){
        this.title = title;
        this.content = content;
        this.lastUpdateDate = new Date();
        this.createDate = new Date();
        this.done = false;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Todo(String content){
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public boolean isDone() {
        return done;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public String getUrl() {
        return url;
    }

    public Category getCategory() {
        return category;
    }

}
