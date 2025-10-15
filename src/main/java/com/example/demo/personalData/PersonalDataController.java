package com.example.demo.personalData;

import com.example.demo.olympiads.OlympiadForm;
import com.example.demo.users.User;
import com.example.demo.users.UserRepository;
import com.example.demo.users.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/personal_data")
public class PersonalDataController {

    private final PersonalDataService personalDataService;

    public PersonalDataController(PersonalDataService personalDataService) {
        this.personalDataService = personalDataService;
    }

    @GetMapping("/form")
    public String getForm(Model model, @AuthenticationPrincipal User user) {
        if (user.isFirstLogin()) {
            model.addAttribute("personalData", new PersonalData());
            return "personal-data";
        }
        return "index";
    }

    @PostMapping
    public String saveForm(Model model, @ModelAttribute("personalData") PersonalData personalData, @AuthenticationPrincipal User user) {
        personalData.setUser(user);
        personalDataService.savePersonalData(personalData);
        model.addAttribute("olympiad", new OlympiadForm());
        return "olympiads-form";
    }
}
