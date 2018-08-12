package com.sc.model;

/**
 * Created by shichong on 2018/8/12
 */
public class DemoObj {
    private long id;
    private String name;

    public DemoObj() {

    }

    public DemoObj(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DemoObj{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
