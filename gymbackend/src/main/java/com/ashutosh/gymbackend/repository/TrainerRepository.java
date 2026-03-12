package com.ashutosh.gymbackend.repository;

import com.ashutosh.gymbackend.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
