package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImp implements CarService {

    public List<Car> createCars() {
        return List.of(
                new Car("Toyota", "Corolla", 1999),
                new Car("Ford", "Focus", 2007),
                new Car("Honda", "Accord", 2010),
                new Car("Chery", "Tiggo4", 2019),
                new Car("Лада", "Калина", 2003)
                );
    }

    @Override
    public List<Car> getCars(List<Car> cars, int numberOfCars) {
        return cars.subList(0, numberOfCars);
    }
}
