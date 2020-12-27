package com.ksptooi.aci.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "command")
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id = null;

    @Column
    private String name = null;

    @Column
    private String type = null;

    @Transient
    private List<Target> targets = null;

    @Column
    private String description = null;

    @Column
    private Date createTime = null;

    @Column
    private String updateTime = null;

    @Column
    private Integer createByAccount = null;

    @Column
    private String permissions = null;

    @Column
    private Integer remove = null;

    @Override
    public String toString() {
        return "Command{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", targets=" + targets +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", updateTime='" + updateTime + '\'' +
                ", createByAccount=" + createByAccount +
                ", permissions='" + permissions + '\'' +
                ", remove=" + remove +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Target> getTargets() {
        return targets;
    }

    public void setTargets(List<Target> targets) {
        this.targets = targets;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCreateByAccount() {
        return createByAccount;
    }

    public void setCreateByAccount(Integer createByAccount) {
        this.createByAccount = createByAccount;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public Integer getRemove() {
        return remove;
    }

    public void setRemove(Integer remove) {
        this.remove = remove;
    }
}
