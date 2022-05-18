package com.medicomp.medicompbackend.model;

public class Medication {
    private int id;
    private String name;

    public Medication(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Medication(){}

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

}
