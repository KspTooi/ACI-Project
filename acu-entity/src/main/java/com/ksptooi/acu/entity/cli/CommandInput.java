package com.ksptooi.acu.entity.cli;

import java.util.List;

public class CommandInput {

    private String name = null;

    private List<String> param = null;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getParam() {
        return param;
    }

    public void setParam(List<String> param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return "CommandIO{" +
                "name='" + name + '\'' +
                ", param=" + param +
                '}';
    }
}
