package com.medicomp.medicompbackend.service;

import com.medicomp.medicompbackend.model.Medication;
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

    public void addMedication(Medication med){
        mediRepository.addMed(med);
        try {
            mediRepository.saveRepository();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
