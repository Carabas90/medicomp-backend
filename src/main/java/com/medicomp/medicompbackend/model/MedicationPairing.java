package com.medicomp.medicompbackend.model;

import java.util.Arrays;

public class MedicationPairing {
    private Medication[] meds;
    private Compatibility comp;

    public MedicationPairing(Medication med1, Medication med2) {
        this.meds = new Medication[]{med1, med2};
        this.comp = Compatibility.UNKNOWN;
    }

    public MedicationPairing(Medication[] meds) {
        if (meds.length == 2) {
            this.meds = meds;
            this.comp = Compatibility.UNKNOWN;
        }
        throw new IllegalArgumentException("Only 2 Medications in Array allowed");
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
       if (Arrays.asList(meds).containsAll(Arrays.asList(other))){
            return true;
        }else {
            return false;
        }
    }

}
