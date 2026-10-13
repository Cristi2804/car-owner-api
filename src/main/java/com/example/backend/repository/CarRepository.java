package com.example.backend.repository;

import com.example.backend.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface CarRepository extends JpaRepository<Car, Long>{
    List<Car> findByBrand(String brand);
    List<Car> findByYear(int year);
}