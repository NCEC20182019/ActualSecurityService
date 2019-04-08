package com.lemmeknow.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="\"user\"")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="email")
    private String email;
    @Column(name="enabled")
    private boolean enabled;
    @Column(name="accountNonExpired")
    private boolean accountNonExpired;
    @Column(name="credentialsNonExpired")
    private boolean credentialsNonExpired;
    @Column(name="accountNonLocked")
    private boolean accountNonLocked;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="role_user",
            joinColumns = {@JoinColumn(name="user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName = "id")})
    private List<Role> roles;


    public User(){

    }

    public User(User user) {
        this.id = user.id;
        this.username = user.username;
        this.password = user.password;
        this.email = user.email;
        this.enabled = user.enabled;
        this.accountNonExpired = user.accountNonExpired;
        this.credentialsNonExpired = user.credentialsNonExpired;
        this.accountNonLocked = user.accountNonLocked;
        this.roles = user.roles;
    }
}
