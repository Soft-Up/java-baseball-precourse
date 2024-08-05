package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static String inputCarNames() {
        boolean success = false;
        String input;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            input = sc.next();
            try {
                InputValidator.validateString(input);
                success = true;
            } catch (IllegalArgumentException e) {
                ErrorView.printError(e);
            }
        } while (!success);
        return input;
    }

    public static String inputRoundNum() {
        boolean success = false;
        String input;
        do {
            System.out.println("시도할 회수는 몇회인가요?");
            input = sc.next();
            try {
                InputValidator.validatePositiveNumber(input);
                success = true;
            } catch (IllegalArgumentException e) {
                ErrorView.printError(e);
            }
        } while (!success);
        return input;
    }
}
