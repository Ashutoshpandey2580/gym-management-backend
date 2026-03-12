package com.ashutosh.gymbackend.repository;

import com.ashutosh.gymbackend.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
