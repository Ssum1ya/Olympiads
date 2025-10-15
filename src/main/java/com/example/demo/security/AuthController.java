package com.example.demo.security;

import com.example.demo.olympiads.OlympiadForm;
import com.example.demo.personalData.PersonalData;
import com.example.demo.users.User;
import com.example.demo.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "auth/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "auth/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, Model model) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        OlympiadForm olympiadForm = new OlympiadForm();
        olympiadForm.setUser(user);

        PersonalData personalData = new PersonalData();
        personalData.setUser(user);

        user.setOlympiadForm(olympiadForm);
        user.setPersonalData(personalData);

        userRepository.save(user);
        return "redirect:/login";
    }
}
