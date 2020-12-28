package com.ksptooi.acu.entity.account;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id = null;

    @Column
    private String displayName = null;

    @Column
    private String account = null;

    @Column
    private String password = null;

    @Column
    private String roles = null;

    @Column
    private Date createTime = null;

    @Column
    private Integer loginCount = null;

    @Column
    private Integer remove = null;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", displayName='" + displayName + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                ", createTime=" + createTime +
                ", loginCount=" + loginCount +
                ", remove=" + remove +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public Integer getRemove() {
        return remove;
    }

    public void setRemove(Integer remove) {
        this.remove = remove;
    }
}
