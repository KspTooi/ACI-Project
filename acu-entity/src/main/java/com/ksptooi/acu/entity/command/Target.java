package com.ksptooi.acu.entity.command;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "target")
public class Target {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id = null;

    @Column(name = "command")
    private Integer command = null;

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

    public Integer getCommand() {
        return command;
    }

    public void setCommand(Integer command) {
        this.command = command;
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
}
