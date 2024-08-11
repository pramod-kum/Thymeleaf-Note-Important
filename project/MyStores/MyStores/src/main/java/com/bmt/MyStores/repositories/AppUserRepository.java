package com.bmt.MyStores.repositories;

import com.bmt.MyStores.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Integer> {
    public AppUser findByEmail(String email);
}
