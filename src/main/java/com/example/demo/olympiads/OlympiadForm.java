package com.example.demo.olympiads;

import com.example.demo.users.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "olympiads")
public class OlympiadForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private List<String> olympiads;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public OlympiadForm() {
    }

    public OlympiadForm(Long id, List<String> olympiads, User user) {
        this.id = id;
        this.olympiads = olympiads;
        this.user = user;
    }

    @Override
    public String toString() {
        return "OlympiadForm{" +
                "id=" + id +
                ", olympiads=" + olympiads +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getOlympiads() {
        return olympiads;
    }

    public void setOlympiads(List<String> olympiads) {
        this.olympiads = olympiads;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
