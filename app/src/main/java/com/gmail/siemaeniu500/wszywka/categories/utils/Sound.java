package com.gmail.siemaeniu500.wszywka.categories.utils;

/**
 * Created by Kamil on 2017-01-20.
 */

public class Sound {
    String name;
    String path;
    int ID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String location) {
        this.path = path;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Sound(String path, String name, int ID) {
        super();
        this.path = path;
        this.ID = ID;
        this.name = name;
    }

}