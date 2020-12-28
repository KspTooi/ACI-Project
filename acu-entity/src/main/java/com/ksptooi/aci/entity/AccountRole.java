package com.ksptooi.aci.entity;

import javax.persistence.*;

@Entity
@Table(name = "account_role")
public class AccountRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id = null;

    @Column
    private String role = null;

    @Column
    private String permissions= null;


    @Override
    public String toString() {
        return "AccountRole{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", permissions='" + permissions + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
}
