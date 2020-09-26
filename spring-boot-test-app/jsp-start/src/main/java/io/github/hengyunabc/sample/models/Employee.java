package io.github.hengyunabc.sample.models;

import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.Serializable;

public class Employee implements Serializable {

    private static final long serialVersionUID = -7788619177798333712L;

    private int id;
    private String name;
    private String role;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
