package com.medicomp.medicompbackend.controller;

import com.medicomp.medicompbackend.model.Medication;
import com.medicomp.medicompbackend.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedicationController {
    @Autowired
    private MedicationService mediService;

    @GetMapping(path = "/medication")
    public List<Medication> getMedications(){
        return mediService.getMedications();
    }

    @PostMapping(path = "/medication")
    public void addMedication(@RequestBody Medication med){
        mediService.addMedication(med);
    }
}
