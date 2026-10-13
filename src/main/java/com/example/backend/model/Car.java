package com.example.backend.model;

import jakarta.persistence.*;
import jakarta.persistence.ManyToOne;
import com.example.backend.model.Owner;
@Entity
public class Car{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String brand;
    private String model;
    @Column(name="production_year")
    private int year;
    public Car() {
    }

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    @ManyToOne
    private Owner owner;
    public Owner getOwner(){
        return owner;
    }
    public void setOwner(Owner owner){
        this.owner=owner;
    }
}