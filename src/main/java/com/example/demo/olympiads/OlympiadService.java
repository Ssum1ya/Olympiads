package com.example.demo.olympiads;

import com.example.demo.users.User;
import com.example.demo.users.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class OlympiadService {

    private final OlympiadRepository olympiadRepository;
    private final UserRepository userRepository;

    public OlympiadService(OlympiadRepository olympiadRepository, UserRepository userRepository) {
        this.olympiadRepository = olympiadRepository;
        this.userRepository = userRepository;
    }

    public void saveOlympiadForm(OlympiadForm olympiadForm) {
        OlympiadForm olympiadFormDB = olympiadRepository.findByUser(olympiadForm.getUser());
        olympiadFormDB.setOlympiads(olympiadForm.getOlympiads());
        olympiadRepository.save(olympiadFormDB);

        User userFromRepository = userRepository.findUserById(olympiadForm.getUser().getId());
        if (userFromRepository.isFirstLogin()) {
            userFromRepository.setFirstLogin(false);
            userRepository.save(userFromRepository);
        }
    }

    public OlympiadForm getOlympiadByUser(User user) {
        return olympiadRepository.findByUser(user);
    }
}
