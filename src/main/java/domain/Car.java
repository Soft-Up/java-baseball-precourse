package domain;

public class Car {
    private static final Integer BOUNDARY_VALUE = 4;

    private final String name;
    private Integer distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void move(Integer number) {
        if (number.compareTo(BOUNDARY_VALUE) >= 0) {
            advance();
        }
    }

    private void advance() {
        this.distance++;
    }

    /**
     * get
     */
    public String getName() {
        return this.name;
    }

    public Integer getDistance() {
        return this.distance;
    }
}
