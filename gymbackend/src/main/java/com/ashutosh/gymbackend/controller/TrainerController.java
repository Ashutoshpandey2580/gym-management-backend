package com.ashutosh.gymbackend.controller;

import com.ashutosh.gymbackend.entity.Trainer;
import com.ashutosh.gymbackend.service.TrainerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainers")
public class TrainerController {

    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService){
        this.trainerService = trainerService;
    }

    @PostMapping
    public Trainer createTrainer(@RequestBody Trainer trainer){
        return trainerService.createTrainer(trainer);
    }

    @GetMapping
    public List<Trainer> getTrainers(){
        return trainerService.getAllTrainers();
    }
}
