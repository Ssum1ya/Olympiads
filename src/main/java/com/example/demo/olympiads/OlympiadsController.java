package com.example.demo.olympiads;

import com.example.demo.users.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/olympiads")
public class OlympiadsController {

    private final OlympiadService olympiadService;

    public OlympiadsController(OlympiadService olympiadService) {
        this.olympiadService = olympiadService;
    }

    @GetMapping
    public String getOlympiadForm(Model model) {
        model.addAttribute("olympiad", new OlympiadForm());
        return "olympiads-form";
    }

    @PostMapping
    public String saveOlympiad(@ModelAttribute("olympiad") OlympiadForm olympiadForm, @AuthenticationPrincipal User user) {
        olympiadForm.setUser(user);
        olympiadService.saveOlympiadForm(olympiadForm);
        user.setFirstLogin(false);
        return "client-main-page.html";
    }

    @GetMapping("/user-olympiads")
    public String getOlympiadsByUser(Model model, @AuthenticationPrincipal User user) {
        OlympiadForm olympiadForm = olympiadService.getOlympiadByUser(user);
        model.addAttribute("olympiad", olympiadForm);
        return "olympiads-form";
    }
}
