package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("car 전진 테스트")
    @Test
    void move_test_when_advance() {
        //given
        Car car = new Car("advance");
        //when
        car.move(4);
        //then
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @DisplayName("car 멈춤 테스트")
    @Test
    void move_test_when_stop() {
        //given
        Car car = new Car("stop");
        //when
        car.move(3);
        //then
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @DisplayName("car move 테스트")
    @Test
    void move_test() {
        //given
        Car car = new Car("move");
        //when
        car.move(0);
        car.move(8);
        car.move(9);
        car.move(5);
        //then
        assertThat(car.getDistance()).isEqualTo(3);
    }

}