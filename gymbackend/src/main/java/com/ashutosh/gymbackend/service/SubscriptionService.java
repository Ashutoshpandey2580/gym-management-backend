package com.ashutosh.gymbackend.service;

import com.ashutosh.gymbackend.entity.Subscription;
import com.ashutosh.gymbackend.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository){
        this.subscriptionRepository = subscriptionRepository;
    }

    public Subscription createSubscription(Subscription subscription){
        return subscriptionRepository.save(subscription);
    }

    public List<Subscription> getSubscriptions(){
        return subscriptionRepository.findAll();
    }
}
