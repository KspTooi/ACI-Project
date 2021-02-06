package com.ksptooi.acu.entity.command;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Entity
@Table(name = "command")
public class Command {

    //主键ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id = null;

    //命令名称
    @Column
    private String name = null;

    //所属引擎
    @Column
    private String engine = null;

    //命令目标
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "cmd_id")
    private List<Target> targets = null;

    //命令描述
    @Column
    private String description = null;

    //创建时间
    @Column(name = "create_time")
    private Date createTime = null;

    //最后更新时间
    @Column(name = "update_time")
    private Date updateTime = null;

    //所有者
    @Column(name = "owner_id")
    private Integer ownerId = null;

    //权限节点
    @Column
    private String permissions = null;

    //逻辑删除 0=正常 1=删除
    @Column
    private Integer remove = null;


    //根据Target名称
    //获取到该引擎的Target实例
    public Target forTarget(String targetName){

        List<Target> targetStream = this.targets.stream()
                .filter(f -> f.getTargetPoint().equalsIgnoreCase(targetName)).collect(Collectors.toList());

        if(targetStream.size()<1){
            return null;
        }

        return targetStream.get(0);
    }


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
                ", ownerId=" + ownerId +
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

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
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
