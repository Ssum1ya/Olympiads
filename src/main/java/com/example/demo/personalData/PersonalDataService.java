package com.example.demo.personalData;

import com.example.demo.users.User;
import com.example.demo.users.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonalDataService {

    private final PersonalDataRepository personalDataRepository;
    private final UserRepository userRepository;

    public PersonalDataService(PersonalDataRepository personalDataRepository, UserRepository userRepository) {
        this.personalDataRepository = personalDataRepository;
        this.userRepository = userRepository;
    }

    public void savePersonalData(PersonalData personalData) {
        PersonalData personalDataDB = personalDataRepository.findPersonalDataByUser(personalData.getUser());
        personalData.setId(personalDataDB.getId());
        personalData.setUser(personalDataDB.getUser());

        User newUser = personalData.getUser();
        userRepository.save(personalData.getUser());

        personalDataRepository.save(personalData);
    }

    public PersonalData getPersonalDataByUser(User user) {
        return personalDataRepository.findPersonalDataByUser(user);
    }
}
