package com.example.dark.baiontonghop.DTO;


/**
 * Created by Dark on 4/23/2017.
 */

public class department_class {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public department_class(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public department_class(String name) {
        this.name = name;
    }
}
