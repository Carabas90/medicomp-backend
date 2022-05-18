package com.medicomp.medicompbackend.service;

import com.medicomp.medicompbackend.model.Medication;
import com.medicomp.medicompbackend.model.MedicationPairing;
import com.medicomp.medicompbackend.repository.MediRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationService {
    private MediRepository mediRepository;

    public MedicationService(){
        try {
            mediRepository = MediRepository.loadRepository();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Medication> getMedications(){
        return mediRepository.getMeds();
    }

    public List<MedicationPairing> getPairings(){
        return mediRepository.getPairings();
    }

    public void addMedication(Medication med){
        mediRepository.addMed(med);
        try {
            mediRepository.saveRepository();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Medication getMedicationById(int id){
        for (Medication med : mediRepository.getMeds()){
            if (med.getId() == id){
                return med;
            }
        }
        throw new IllegalArgumentException("No Medication with this id found");
    }

    public MedicationPairing getPairingById(int id){
        for (MedicationPairing pair: mediRepository.getPairings()){
            if (pair.getId()== id){
                return pair;
            }
        }
        throw new IllegalArgumentException("No Pairing with this id found");
    }



}
