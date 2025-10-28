package com.example.demo.users;

import com.example.demo.olympiads.OlympiadForm;
import com.example.demo.personalData.PersonalData;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "olympiad_users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "username is required")
    private String username;
    @NotBlank(message = "password is required")
    private String password;
    @Transient
    private String secondPassword;
    private boolean isFirstLogin = true;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private PersonalData personalData = new PersonalData();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private OlympiadForm olympiadForm = new OlympiadForm();

    public User() {
    }

    public User(Long id, String username, String password, String secondPassword, boolean isFirstLogin, PersonalData personalData, OlympiadForm olympiadForm) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.secondPassword = secondPassword;
        this.isFirstLogin = isFirstLogin;
        this.personalData = personalData;
        this.olympiadForm = olympiadForm;
    }

    public boolean isFirstLogin() {
        return isFirstLogin;
    }

    public void setFirstLogin(boolean firstLogin) {
        isFirstLogin = firstLogin;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isFirstLogin=" + isFirstLogin +
                ", personalData=" + personalData +
                ", olympiadForm=" + olympiadForm +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public OlympiadForm getOlympiadForm() {
        return olympiadForm;
    }

    public void setOlympiadForm(OlympiadForm olympiadForm) {
        this.olympiadForm = olympiadForm;
    }

    public String getSecondPassword() {
        return secondPassword;
    }

    public void setSecondPassword(String secondPassword) {
        this.secondPassword = secondPassword;
    }
}
