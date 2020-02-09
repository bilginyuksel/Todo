package com.bilginyuksel.todo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;

    @OneToMany
    private Set<Permission> permissions;

    public Role(){}

    public Role(String title, Set<Permission> permissions){
        this.title = title;
        this.permissions = permissions;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

}
