package com.medicomp.medicompbackend.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicationTest {

    @Test
    void testEquals() {
        assertTrue(new Medication(1,"test").equals(new Medication(1, "test")));
    }

    @Test
    void testEqualsNegativeTest() {
        assertFalse(new Medication(2,"test").equals(new Medication(1, "test")));
    }
}