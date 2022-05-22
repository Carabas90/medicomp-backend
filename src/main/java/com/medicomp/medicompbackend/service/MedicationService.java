package com.medicomp.medicompbackend.service;

import com.medicomp.medicompbackend.model.Medication;
import com.medicomp.medicompbackend.model.MedicationPairing;
import com.medicomp.medicompbackend.repository.MediRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicationService {
    private MediRepository mediRepository;

    public MedicationService() {
        try {
            mediRepository = MediRepository.loadRepository();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Medication> getMedications() {
        return mediRepository.getMeds();
    }

    public List<MedicationPairing> getPairings() {
        return mediRepository.getPairings();
    }

    public void addMedication(Medication med) {
        mediRepository.addMed(med);
        try {
            mediRepository.saveRepository();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Medication getMedicationById(int id) {
        for (Medication med : mediRepository.getMeds()) {
            if (med.getId() == id) {
                return med;
            }
        }
        throw new IllegalArgumentException("No Medication with this id found");
    }

    public MedicationPairing getPairingById(int id) {
        for (MedicationPairing pair : mediRepository.getPairings()) {
            if (pair.getId() == id) {
                return pair;
            }
        }
        throw new IllegalArgumentException("No Pairing with this id found");
    }


    public List<MedicationPairing> getPairingsForMedication(int id) {
        List<MedicationPairing> result = new ArrayList<>();
        for (MedicationPairing pairing : mediRepository.getPairings()) {
            if (pairing.containsMedicationWithId(id)) {
                result.add(pairing);
            }
        }
        return result;
    }

    public void updateMedication(int id, Medication medInfo) {
        Medication med = getMedicationById(id);
        med.setName(medInfo.getName());
    }

    public void updatePairing(int id, MedicationPairing pairingInfo) {
        MedicationPairing pairing = getPairingById(id);
        pairing.setComp(pairingInfo.getComp());
    }

    public void deleteMedication(int id) {
        mediRepository.deleteMedication(getMedicationById(id));
    }
}
