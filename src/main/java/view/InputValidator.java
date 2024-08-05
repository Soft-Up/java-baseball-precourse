package view;

public class InputValidator {
    public static void validateString(String input) {
        isNotEmpty(input);
    }

    public static void validatePositiveNumber(String input) {
        isNotEmpty(input);
        isInteger(input);
        isPositive(input);
    }

    private static void isNotEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력 문자열이 공백입니다.");
        }
    }

    private static void isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력해 주세요.");
        }
    }

    private static void isPositive(String input) {
        if (Integer.parseInt(input) < 1) {
            throw new IllegalArgumentException("양수를 입력해 주세요.");
        }
    }
}
