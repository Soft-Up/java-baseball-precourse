package Service;

import domain.Car;
import domain.NumberGenerator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarService {
    private static final Integer CAR_NAME_LENGTH = 5;

    private final List<Car> cars = new ArrayList<>();
    private final NumberGenerator numberGenerator;

    public CarService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void addCars(String[] names) {
        for (String name : names) {
            validateCarName(name);
            cars.add(new Car(name));
        }
    }

    public Map<String, Integer> run() {
        Map<String, Integer> roundResult = new HashMap<>();
        for (Car car : cars) {
            car.move(numberGenerator.generate());
            roundResult.put(car.getName(), car.getDistance());
        }
        return roundResult;
    }

    public List<String> findWinner() {
        Car winner = cars.stream()
                .max(Comparator.comparingInt(Car::getDistance)).get();
        return cars.stream()
                .filter(car -> car.getDistance().equals(winner.getDistance()))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    /**
     * validate
     */
    private void validateCarName(String name) throws IllegalArgumentException {
        validateCarNameLength(name);
        validateCarNameDup(name);
    }

    private void validateCarNameLength(String name) throws IllegalArgumentException {
        if (name.length() > CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름이 너무 깁니다.");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 공백입니다.,");
        }
    }

    private void validateCarNameDup(String name) throws IllegalArgumentException {
        if (cars.stream().anyMatch(car -> car.getName().equals(name))) {
            throw new IllegalArgumentException("자동차 이름이 중복 됩니다.");
        }
    }
}
