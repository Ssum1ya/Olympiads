package com.example.demo.personalData;

import com.example.demo.olympiads.OlympiadForm;
import com.example.demo.users.User;
import com.example.demo.users.UserRepository;
import com.example.demo.users.UserService;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
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
        return "client-main-page.html";
    }

    @PostMapping
    public String saveForm(Model model, @ModelAttribute("personalData") @Valid PersonalData personalData, Errors errors, @AuthenticationPrincipal User user) {
        if (errors.hasErrors()) {
            return "personal-data";
        }
        personalData.setUser(user);
        personalDataService.savePersonalData(personalData);
        if (user.isFirstLogin()) {
            model.addAttribute("olympiad", new OlympiadForm());
            return "olympiads-form";
        }
        return "client-main-page.html";
    }

    @GetMapping("/user-data")
    public String getPersonalData(Model model, @AuthenticationPrincipal User user) {
        PersonalData personalData = personalDataService.getPersonalDataByUser(user);
        model.addAttribute("personalData", personalData);
        return "personal-data";
    }
}
