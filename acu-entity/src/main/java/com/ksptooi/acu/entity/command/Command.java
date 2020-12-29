package com.ksptooi.acu.entity.command;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Table(name = "command")
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id = null;

    @Column
    private String name = null;

    @Column
    private String engine = null;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "command")
    private List<Target> targets = null;

    @Column
    private String description = null;

    @Column
    private Date createTime = null;

    @Column
    private Date updateTime = null;

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
                ", engine='" + engine + '\'' +
                ", targets=" + targets +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createByAccount=" + createByAccount +
                ", permissions='" + permissions + '\'' +
                ", remove=" + remove +
                '}';
    }


    public Target forTarget(String targetName){

        List<Target> targetStream = this.targets.stream()
                .filter(f -> f.getTarget().equalsIgnoreCase(targetName)).collect(Collectors.toList());

        if(targetStream.size()<1){
            return null;
        }

        return targetStream.get(0);
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

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
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
