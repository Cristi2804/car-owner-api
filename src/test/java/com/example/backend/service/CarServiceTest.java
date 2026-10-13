package com.example.backend.service;
import com.example.backend.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import com.example.backend.model.Car;
import static org.mockito.Mockito.when;
import java.util.List;
import com.example.backend.dto.CarResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @Mock
    private CarRepository carRepository;
    @InjectMocks
    private CarService carService;

    @Test
    void shouldGetAllCars() {

        Car car = new Car();
        car.setBrand("BMW");
        car.setModel("X5");
        car.setYear(2025);
        when(carRepository.findAll()).thenReturn(List.of(car));

        List<CarResponse> result = carService.getAllCars();
        assertEquals(1, result.size());
        assertEquals("BMW", result.get(0).getBrand());
        assertEquals("X5", result.get(0).getModel());
        assertEquals(2025, result.get(0).getYear());
    }
}
