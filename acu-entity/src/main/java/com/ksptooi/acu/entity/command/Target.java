package com.ksptooi.acu.entity.command;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "targets")
public class Target {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id = null;

    @Column(name = "cmd_id")
    private Integer cmdId = null;

    //该目标指向的类型
    // mode_engine 指向引擎
    // mode_link 指向文件/文件夹或其他内容
    @Column
    private String model = null;

    //表示实际的目标点
    @Column(name = "target_point")
    private String targetPoint = null;

    //创建时间
    @Column(name = "create_time")
    private Date createTime = null;

    //逻辑删除 0=正常 1=移除
    @Column
    private Integer remove = 0;

    @Override
    public String toString() {
        return "Target{" +
                "id=" + id +
                ", cmdId=" + cmdId +
                ", model='" + model + '\'' +
                ", targetPoint='" + targetPoint + '\'' +
                ", createTime=" + createTime +
                ", remove=" + remove +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCmdId() {
        return cmdId;
    }

    public void setCmdId(Integer cmdId) {
        this.cmdId = cmdId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTargetPoint() {
        return targetPoint;
    }

    public void setTargetPoint(String targetPoint) {
        this.targetPoint = targetPoint;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getRemove() {
        return remove;
    }

    public void setRemove(Integer remove) {
        this.remove = remove;
    }

}


