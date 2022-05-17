package com.medicomp.medicompbackend.repository;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.medicomp.medicompbackend.model.Medication;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MediRepository {
    private List<Medication> meds;
    private static final String path = "src/main/resources/MediRepository.json";
    private static int highestId;

    private MediRepository() {
        this.meds = new ArrayList<>();
    }

    public static MediRepository loadRepository() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader reader = gson.newJsonReader(new FileReader(path));
        return gson.fromJson(reader, MediRepository.class);
    }

    public void saveRepository() throws IOException {
        Writer writer = new FileWriter(path);
        new Gson().toJson(this, writer);
        writer.close();
    }

    public void addMed(Medication med) {
        if (!meds.contains(med)) {
            meds.add(new Medication(++highestId, med.getName()));
        }
    }

    public List<Medication> getMeds() {
        return meds;
    }

}
