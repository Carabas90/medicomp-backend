package com.medicomp.medicompbackend.service;

import com.medicomp.medicompbackend.model.Compatibility;
import com.medicomp.medicompbackend.model.Medication;
import com.medicomp.medicompbackend.model.MedicationPairing;
import com.medicomp.medicompbackend.repository.MediRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MedicationServiceTest {
    MedicationService service;

    @BeforeEach
    public void setupService(){
        service = new MedicationService(new MediRepository());
    }

    @Test
    void addMedication() {
        service.addMedication(new Medication(0,"test0"));
        assertTrue(service.getMedications().contains(new Medication(1,"test0")));
    }

    @Test
    void getMedicationById() {
        Medication med = new Medication(1,"test0");
        service.addMedication(med);
        assertEquals(med, service.getMedicationById(1));
    }

    @Test
    void getPairingById() {
        service.addMedication(new Medication(0, "test0"));
        service.addMedication(new Medication(1, "test1"));
        assertTrue(service.getPairingById(1).containsMedicationWithName("test0"));
        assertTrue(service.getPairingById(1).containsMedicationWithName("test1"));
    }

    @Test
    void getPairingsForMedication() {
        service.addMedication(new Medication(1, "test1"));
        service.addMedication(new Medication(2, "test2"));
        service.addMedication(new Medication(3, "test3"));
        List<MedicationPairing> pairings = service.getPairingsForMedication(1);
        assertTrue(pairings.contains(service.getPairingById(1)));
        assertTrue(pairings.contains(service.getPairingById(2)));
        assertFalse(pairings.contains(service.getPairingById(3)));
    }

    @Test
    void updateMedication() {
        service.addMedication(new Medication(1, "test1"));
        service.updateMedication(1, new Medication(1, "test2"));
        assertEquals("test2", service.getMedicationById(1).getName());
    }

    @Test
    void updatePairing() {
        MedicationPairing pairing = new MedicationPairing(1,new Medication(1, "test1"),new Medication(2, "test2"));
        pairing.setComp(Compatibility.INCOMPATIBLE);
        service.addMedication(new Medication(1, "test1"));
        service.addMedication(new Medication(2, "test2"));
        service.updatePairing(1, pairing);
        assertEquals(Compatibility.INCOMPATIBLE, service.getPairingById(1).getComp());
    }

}