package com.ashutosh.gymbackend.entity;

import jakarta.persistence.*;

@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String specialization;

    public Trainer(){}

    public Long getId(){
        return id;

    }
    public String getName(){
        return name;

    }
    public void SetName(String name){
        this.name=name;
    }
    public String getSpecialization(){
        return specialization;
    }
    public  void setSpecialization(String specialization){
        this.specialization=specialization;
    }
}
