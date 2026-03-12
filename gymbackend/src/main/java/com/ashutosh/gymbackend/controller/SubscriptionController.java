package com.ashutosh.gymbackend.controller;

import com.ashutosh.gymbackend.entity.Subscription;
import com.ashutosh.gymbackend.service.SubscriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService){
        this.subscriptionService = subscriptionService;
    }

    @PostMapping
    public Subscription createSubscription(@RequestBody Subscription subscription){
        return subscriptionService.createSubscription(subscription);
    }

    @GetMapping
    public List<Subscription> getSubscriptions(){
        return subscriptionService.getSubscriptions();
    }
}
