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
    private Integer cmd_id = null;

    @Column
    private String path = null;

    @Column
    private String file = null;

    @Column
    private String targetPoint = null;

    @Column
    private String model = null;

    @Column
    private Date createTime = null;

    @Column
    private Integer remove = 0;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCmd_id() {
        return cmd_id;
    }

    public void setCmd_id(Integer command) {
        this.cmd_id = command;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getTargetPoint() {
        return targetPoint;
    }

    public void setTargetPoint(String targetPoint) {
        this.targetPoint = targetPoint;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    @Override
    public String toString() {
        return "Target{" +
                "id=" + id +
                ", command=" + cmd_id +
                ", path='" + path + '\'' +
                ", file='" + file + '\'' +
                ", targetPoint='" + targetPoint + '\'' +
                ", model='" + model + '\'' +
                ", createTime=" + createTime +
                ", remove=" + remove +
                '}';
    }
}
