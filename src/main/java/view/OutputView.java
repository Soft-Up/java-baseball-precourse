package view;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printRoundResultInit() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printRoundResult(Map<String, Integer> cars) {
        for (Map.Entry<String, Integer> car : cars.entrySet()) {
            System.out.println(car.getKey() + " : " + "-".repeat(car.getValue()));
        }
        System.out.println();
    }

    public static void printWinner(List<String> winners){
        System.out.print("최종 우승자 : "+String.join(", ",winners));
    }
}
