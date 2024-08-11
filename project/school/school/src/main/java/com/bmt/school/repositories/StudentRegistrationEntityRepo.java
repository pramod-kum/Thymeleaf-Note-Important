package com.bmt.school.repositories;

import com.bmt.school.models.StudentRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRegistrationEntityRepo extends JpaRepository<StudentRegistrationEntity,Long> {
}
