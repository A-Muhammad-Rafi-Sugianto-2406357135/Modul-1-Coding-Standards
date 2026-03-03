package id.ac.ui.cs.advprog.eshop.service;
import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car create(Car car) {
        // TODO Auto-generated method stub
        return carRepository.create(car);
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Car findById(String carId) {
        Car car = carRepository.findById(carId);
        if (car == null) {
            throw new RuntimeException("Car not found");
        }
        return car;
    }

    @Override
    public Car update(String carId, Car car) {
        Car updated = carRepository.update(carId, car);
        if (updated == null) {
            throw new RuntimeException("Car not found");
        }
        return updated;
    }

    @Override
    public void deleteCarById(String carId) {
        carRepository.delete(carId);
    }
}