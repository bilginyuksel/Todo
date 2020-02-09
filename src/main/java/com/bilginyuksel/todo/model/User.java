package com.bilginyuksel.todo.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username, password;
    private String email; // Maybe share via email.
    private Date registerDate, lastLoginDate;

    @ManyToOne
    private Role role;


    public User(){

    }

    public User(String username){
        this.username = username;
    }

    public User(String username, String password, String email){
        // Registeration Process.
        this.username = username;
        this.password = password;
        this.email = email;
        this.registerDate = new Date();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", registerDate=" + registerDate +
                ", lastLoginDate=" + lastLoginDate +
                ", role=" + role +
                '}';
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public Role getRole() {
        return role;
    }
}
