package com.example.demo.olympiads;

import org.springframework.stereotype.Service;

@Service
public class OlympiadService {

    private final OlympiadRepository olympiadRepository;

    public OlympiadService(OlympiadRepository olympiadRepository) {
        this.olympiadRepository = olympiadRepository;
    }

    public void saveOlympiadForm(OlympiadForm olympiadForm) {
        OlympiadForm olympiadFormDB = olympiadRepository.findByUser(olympiadForm.getUser());
        olympiadFormDB.setOlympiads(olympiadForm.getOlympiads());
        olympiadRepository.save(olympiadFormDB);
    }
}
