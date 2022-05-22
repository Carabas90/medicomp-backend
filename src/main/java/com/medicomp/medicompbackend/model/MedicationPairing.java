package com.medicomp.medicompbackend.model;

import java.util.Arrays;

public class MedicationPairing {
    private int id;
    private Medication[] meds;
    private Compatibility comp;

    public MedicationPairing(int id, Medication med1, Medication med2) {
        this.id = id;
        this.meds = new Medication[]{med1, med2};
        this.comp = Compatibility.UNKNOWN;
    }

    public MedicationPairing(int id, Medication[] meds) {
        if (meds.length == 2) {
            this.id = id;
            this.meds = meds;
            this.comp = Compatibility.UNKNOWN;
        }
        throw new IllegalArgumentException("Only 2 Medications in Array allowed");
    }

    public MedicationPairing(){

    }

    public Compatibility getComp() {
        return comp;
    }

    public void setComp(Compatibility comp) {
        this.comp = comp;
    }

    public Medication[] getMeds() {
        return meds;
    }

    public boolean equals(MedicationPairing other) {
       if (Arrays.asList(meds).containsAll(Arrays.asList(other.getMeds()))){
            return true;
        }else {
            return false;
        }
    }

    public int getId() {
        return id;
    }

    public boolean containsMedicationWithName(String name) {
        if (meds[0].getName().equals(name) || meds[1].getName().equals(name)){
            return true;
        }else{
            return false;
        }
    }

    public boolean containsMedicationWithId(int id) {
        if (meds[0].getId() == id || meds[1].getId() == id){
            return true;
        }else{
            return false;
        }
    }
}
