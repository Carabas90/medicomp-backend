package com.medicomp.medicompbackend.repository;

import com.medicomp.medicompbackend.model.Medication;
import com.medicomp.medicompbackend.model.MedicationPairing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MediRepositoryTest {
    MediRepository repo;

    @BeforeEach
    public void setupRepository(){
        repo = new MediRepository();
    }

    @Test
    void addMed() {
        repo.addMed(new Medication(0,"test0"));
        repo.addMed(new Medication(1, "test1"));
        repo.addMed(new Medication(2, "test2"));
        assertTrue(repo.getMeds().contains(new Medication(1,"test0")));
        assertTrue(repo.getMeds().contains(new Medication(2, "test1")));
        assertTrue(repo.getMeds().contains(new Medication(3, "test2")));
        assertTrue(repo.getPairings().get(0).containsMedicationWithName("test0"));
        assertTrue(repo.getPairings().get(0).containsMedicationWithName("test1"));
        assertTrue(repo.getPairings().get(1).containsMedicationWithName("test2"));
        assertTrue(repo.getPairings().get(1).containsMedicationWithName("test0"));
    }

    @Test
    void deleteMedication() {
        repo.addMed(new Medication(0,"test0"));
        repo.addMed(new Medication(0,"test1"));
        repo.addMed(new Medication(0,"test2"));
        repo.deleteMedication(new Medication(1,"test0"));
        repo.deleteMedication(new Medication(2,"test1"));
        repo.deleteMedication(new Medication(3,"test2"));
        assertTrue(repo.getMeds().isEmpty());
        assertTrue(repo.getPairings().isEmpty());
    }
}