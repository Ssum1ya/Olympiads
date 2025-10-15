package com.example.demo.olympiads;

import com.example.demo.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OlympiadRepository extends JpaRepository<OlympiadForm, Long> {
    OlympiadForm findByUser(User user);
}
