package domain;

public class Car {
    private static final Integer BOUNDARY_VALUE = 4;

    private final String name;
    private Integer distance;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.distance = 0;
    }

    public void move(Integer number) {
        if (number.compareTo(BOUNDARY_VALUE) >= 0) {
            advance();
        }
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

    /**
     * private 메서드
     */
    private void advance() {
        this.distance++;
    }

    private void validate(String name) {
        if (name.length() > 6) {
            throw new IllegalArgumentException("name length is greater than 5");
        }
    }

}
