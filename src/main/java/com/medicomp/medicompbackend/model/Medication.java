package com.medicomp.medicompbackend.model;

import java.util.ArrayList;
import java.util.List;

public class Medication {
    private int id;
    private String name;
    private List<Medication> incompatibleMeds;
    private List<Medication> unknownCompatibility;

    public Medication(int id, String name, List<Medication> incompatibleMeds, List<Medication> unknownCompatibility) {
        this.id = id;
        this.name = name;
        this.incompatibleMeds = incompatibleMeds;
        this.unknownCompatibility = unknownCompatibility;
    }

    public Medication(int id, String name) {
        this.id = id;
        this.name = name;
        this.incompatibleMeds = new ArrayList<>();
        this.unknownCompatibility = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addIncompatible(Medication med) {
        if (!incompatibleMeds.contains(med)) {
            incompatibleMeds.add(med);
        }
    }

    public List<Medication> getIncompatibleMeds() {
        return incompatibleMeds;
    }

    public List<Medication> getUnknownCompatibility() {
        return unknownCompatibility;
    }

    public void addUnknownComp(Medication med) {
        if (!unknownCompatibility.contains(med)) {
            unknownCompatibility.add(med);
        }
    }

}
