package com.gemstones.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USER")
public class UserEntity extends BaseEntity{

    @Column
    private String username;

    @Column
    private String password;

    @Column(name = "fullName")
    private String fullname;

    @Column
    private String status;

    @ManyToMany
    @JoinTable(name="USER_ROLE", joinColumns = @JoinColumn(name="userId"), inverseJoinColumns = @JoinColumn(name = "roleId"))
    private List<RoleEntity> roles = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }
}
