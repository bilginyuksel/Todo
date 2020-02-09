package com.bilginyuksel.todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String permission;

    public Permission(){}

    public Permission(String permission){
        this.permission = permission;
    }

    public Integer getId() {
        return id;
    }

    public String getPermission() {
        return permission;
    }
}
