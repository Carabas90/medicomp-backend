package com.medicomp.medicompbackend.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicationPairingTest {

    @Test
    void testEquals() {
        assertTrue(new MedicationPairing(1, new Medication(1, "test"), new Medication(2, "test2")).equals(new MedicationPairing(1, new Medication(1, "test"), new Medication(2, "test2"))));
    }

    @Test
    void negativeTestEquals() {
        assertFalse(new MedicationPairing(1, new Medication(1, "test3"), new Medication(2, "test2")).equals(new MedicationPairing(1, new Medication(1, "test"), new Medication(2, "test2"))));
    }

    @Test
    void containsMedicationWithName() {
        MedicationPairing pairing = new MedicationPairing(1, new Medication(1, "test"), new Medication(2, "test2"));
        assertTrue(pairing.containsMedicationWithName("test"));
    }

    @Test
    void containsMedicationWithNameNegativeTest() {
        MedicationPairing pairing = new MedicationPairing(1, new Medication(1, "test"), new Medication(2, "test2"));
        assertFalse(pairing.containsMedicationWithName("test3"));
    }

    @Test
    void containsMedicationWithId() {
        MedicationPairing pairing = new MedicationPairing(1, new Medication(1, "test"), new Medication(2, "test2"));
        assertTrue(pairing.containsMedicationWithId(1));
    }

    @Test
    void containsMedicationWithIdNegativeTest() {
        MedicationPairing pairing = new MedicationPairing(1, new Medication(1, "test"), new Medication(2, "test2"));
        assertFalse(pairing.containsMedicationWithId(3));
    }

    @Test
    void contains() {
        MedicationPairing pairing = new MedicationPairing(1, new Medication(1, "test"), new Medication(2, "test2"));
        assertTrue(pairing.contains(new Medication(1, "test")));
    }

    @Test
    void containsNegativeTest() {
        MedicationPairing pairing = new MedicationPairing(1, new Medication(1, "test"), new Medication(2, "test2"));
        assertFalse(pairing.contains(new Medication(4, "test")));
    }
}