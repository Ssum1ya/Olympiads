package com.example.demo.personalData;

import org.springframework.stereotype.Service;

@Service
public class PersonalDataService {

    private final PersonalDataRepository personalDataRepository;

    public PersonalDataService(PersonalDataRepository personalDataRepository) {
        this.personalDataRepository = personalDataRepository;
    }

    public void savePersonalData(PersonalData personalData) {
        PersonalData personalDataDB = personalDataRepository.findPersonalDataByUser(personalData.getUser());
        personalData.setId(personalDataDB.getId());
        personalData.setUser(personalDataDB.getUser());
        personalDataRepository.save(personalData);
    }
}
