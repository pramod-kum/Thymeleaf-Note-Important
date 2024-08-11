package com.bmt.school.repositories;

import com.bmt.school.models.RecentActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecentActivityRepository extends JpaRepository<RecentActivityEntity,Long> {
}
