package com.example.backend.controller;
import org.springframework.http.ResponseEntity;
import com.example.backend.model.Car;
import com.example.backend.service.CarService;
import com.example.backend.dto.CarRequest;
import com.example.backend.dto.CarResponse;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;

@RestController
public class Controller {

    private final CarService carService;

    public Controller(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/cars")
    public ResponseEntity<CarResponse> createCar(@Valid @RequestBody CarRequest carRequest) {
        CarResponse carResponse = carService.createCar(carRequest);
        return ResponseEntity.status(201).body(carResponse);
    }

    @GetMapping("/cars")
    public List<CarResponse> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/cars/{id}")
    public CarResponse getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }
    @GetMapping("/cars/brand/{brand}")
    public List<Car> getCarsByBrand(@PathVariable String brand) {
        return carService.getCarsByBrand(brand);
    }
    @GetMapping("/cars/year/{year}")
    public List<Car> getCarsByYear(@PathVariable int year){
        return carService.getCarsByYear(year);
    }
    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Void> deleteCarById(@PathVariable Long id) {

        carService.deleteCarById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/cars/{id}")
    public CarResponse updateCar(@Valid
            @PathVariable Long id,
            @RequestBody CarRequest carRequest) {
        return carService.updateCar(id, carRequest);
    }

    }

