package com.bmt.school.repositories;

import com.bmt.school.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Integer> {
    public AppUser findByEmail(String email);
}
