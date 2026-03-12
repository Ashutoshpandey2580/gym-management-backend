package com.ashutosh.gymbackend.service;

import com.ashutosh.gymbackend.entity.Trainer;
import com.ashutosh.gymbackend.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository){
        this.trainerRepository = trainerRepository;
    }

    public Trainer createTrainer(Trainer trainer){
        return trainerRepository.save(trainer);
    }

    public List<Trainer> getAllTrainers(){
        return trainerRepository.findAll();
    }
}
