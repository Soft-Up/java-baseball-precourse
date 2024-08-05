package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarServiceTest {
    static class FakeNumberGenerator implements NumberGenerator {
//        private static final Integer[] numbers = {4,2,5,8,8,5,4,5,6,1,2,3,3,3,7};
        private static final Integer[] numbers = {4,5,6,4,5,6,4,5,6,4,5,6,4,5,6};
        private int i = 0;

        @Override
        public Integer generate(){
            return numbers[i++];
        }

        public static int getNumbersSize(){
            return numbers.length;
        }
    }

    CarService carService;

    @BeforeEach
    void setCarService(){
        this.carService = new CarService(new FakeNumberGenerator());
    }

    @DisplayName("car 이름 중복 테스트")
    @Test
    void car_names_dup_test() {
        //given
        List<String> names = List.of("pobi", "woni", "jun", "pobi");
        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> carService.addCars(names));
        //then
        // 예외의 타입 확인
        assertThat(exception).isInstanceOf(IllegalArgumentException.class);
        // 예외 메시지 확인
        assertThat(exception.getMessage()).isEqualTo("자동차 이름이 중복 됩니다.");
    }

    @DisplayName("car 이름 공백 테스트")
    @Test
    void car_names_empty_test() {
        //given
        List<String> names = List.of("pobi", "woni", "jun", "");
        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> carService.addCars(names));
        //then
        // 예외의 타입 확인
        assertThat(exception).isInstanceOf(IllegalArgumentException.class);
        // 예외 메시지 확인
        assertThat(exception.getMessage()).isEqualTo("자동차 이름이 공백입니다.");
    }

    @DisplayName("car 이름 길이 테스트")
    @Test
    void car_names_length_test() {
        //given
        List<String> names = List.of("pobi", "woni", "abcdef");
        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> carService.addCars(names));
        //then
        // 예외의 타입 확인
        assertThat(exception).isInstanceOf(IllegalArgumentException.class);
        // 예외 메시지 확인
        assertThat(exception.getMessage()).isEqualTo("자동차 이름이 너무 깁니다.");
    }

    @DisplayName("경주 우승자 찾기")
    @Test
    void car_find_winner_test() {
        //given
        List<String> names = List.of("pobi", "woni", "jun");
        //when
        carService.addCars(names);
        for(int i=0;i<FakeNumberGenerator.getNumbersSize()/3;i++) {
            carService.run();
        }
        List<String> winners = carService.findWinner();
        //then
        assertThat(winners).isEqualTo(List.of("pobi","woni","jun"));
    }
}