package com.lemmeknow.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @JsonIgnore
    @Column(name="password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="user_role",
               joinColumns = @JoinColumn(name="id"),
               inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> roles;

    public User() {
    }

    public User(String email, int role, String password,Set<Role> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public User(User user){
        this.email = user.email;
        this.roles = user.roles;
        this.id = user.id;
        this.password = user.password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}