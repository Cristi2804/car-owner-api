package com.example.backend.model;
import jakarta.persistence.*;

import java.util.List;
import com.example.backend.model.Car;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    public Owner(){

    }
    public Owner(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @OneToMany(mappedBy = "owner")
    private List<Car> cars;

}

