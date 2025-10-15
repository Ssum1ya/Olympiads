package com.example.demo.personalData;

import com.example.demo.users.User;
import jakarta.persistence.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@Entity
public class PersonalData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String lastName;
    private int classNumber;
    private String classLetter;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public PersonalData() {
    }

    public PersonalData(Long id, String name, String surname, String lastName, int classNumber, String classLetter, @AuthenticationPrincipal User user) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.lastName = lastName;
        this.classNumber = classNumber;
        this.classLetter = classLetter;
        this.user = user;
    }

    @Override
    public String toString() {
        return "PersonalData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", classNumber=" + classNumber +
                ", classLetter='" + classLetter + '\'' +
                ", user=" + user +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public String getClassLetter() {
        return classLetter;
    }

    public void setClassLetter(String classLetter) {
        this.classLetter = classLetter;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
