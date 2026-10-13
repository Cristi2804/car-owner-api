package com.example.backend.service;
import com.example.backend.model.Owner;
import com.example.backend.repository.CarRepository;
import com.example.backend.model.Car;
import com.example.backend.dto.CarRequest;
import com.example.backend.dto.CarResponse;
import com.example.backend.exception.CarNotFoundException;
import com.example.backend.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final OwnerRepository ownerRepository;

    public CarService(CarRepository carRepository,
                      OwnerRepository ownerRepository){
        this.carRepository=carRepository;
        this.ownerRepository=ownerRepository;
    }

    public CarResponse createCar(CarRequest carRequest) {

        Car car = new Car();

        car.setBrand(carRequest.getBrand());
        car.setModel(carRequest.getModel());
        car.setYear(carRequest.getYear());

        Owner owner = ownerRepository.findById(carRequest.getOwnerId())
                .orElseThrow(() -> new RuntimeException("Owner not found"));

        car.setOwner(owner);

        Car savedCar = carRepository.save(car);

        return new CarResponse(
                savedCar.getBrand(),
                savedCar.getModel(),
                savedCar.getYear()
        );
    }

    public List<CarResponse> getAllCars() {
        return carRepository.findAll()
                .stream()
                .map(car -> new CarResponse(
                        car.getBrand(),
                        car.getModel(),
                        car.getYear()
                ))
                .toList();
    }
    public CarResponse getCarById(Long id) {

        Car car = carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));

        return new CarResponse(
                car.getBrand(),
                car.getModel(),
                car.getYear()
        );
    }
    public void deleteCarById(Long id) {
        carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));

        carRepository.deleteById(id);
    }

    public CarResponse updateCar(Long id, CarRequest carRequest) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));
        car.setBrand(carRequest.getBrand());
        car.setModel(carRequest.getModel());
        car.setYear(carRequest.getYear());
        Car savedCar = carRepository.save(car);
        return new CarResponse(
                savedCar.getBrand(),
                savedCar.getModel(),
                savedCar.getYear()
        );
    }
    public List<Car> getCarsByBrand(String brand){

        return carRepository.findByBrand(brand);
    }

    public List<Car> getCarsByYear(int year){
    return carRepository.findByYear(year);
    }


}
