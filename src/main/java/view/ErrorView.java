package view;

public class ErrorView {
    public static void printError(RuntimeException error){
        System.out.println("[ERROR] "+error.getMessage());
    }
}
