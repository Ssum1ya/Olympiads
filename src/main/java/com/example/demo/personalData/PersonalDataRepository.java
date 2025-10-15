package com.example.demo.personalData;

import com.example.demo.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalDataRepository extends JpaRepository<PersonalData, Long> {
    PersonalData findPersonalDataByUser(User user);
}
