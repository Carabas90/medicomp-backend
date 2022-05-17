package com.medicomp.medicompbackend.controller;

import com.medicomp.medicompbackend.model.Medication;
import com.medicomp.medicompbackend.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MedicationController {
    @Autowired
    private MedicationService mediService;

    @GetMapping(path = "/medication")
    public List<Medication> getMedications(){
        return mediService.getMedications();
    }

    @GetMapping(path="/medication/{id}")
    public Medication getMedication(@PathVariable int id){
        return mediService.getMedicationById(id);
    }

    @PostMapping(path = "/medication")
    public void addMedication(@RequestBody Medication med){
        mediService.addMedication(med);
    }

    @PostMapping(path = "/medication/{id}/incomp/{foreignId}")
    public void addIncompatibility(@PathVariable int id, @PathVariable int foreignId){
        mediService.addIncompatibility(id, foreignId);
    }
}
