package controller;

import Service.CarService;
import domain.RandomNumberGenerator;
import view.ErrorView;
import view.InputView;
import view.OutputView;

public class GameController {
    private final CarService carService;
    private Integer roundNum;

    public GameController() {
        this.carService = new CarService(new RandomNumberGenerator());
    }

    public void start() {
        setUpCars();
        setUpRoundNum();
        runRound();
        findWinner();
    }

    private void setUpCars() {
        boolean success = false;
        do {
            try {
                carService.addCars(InputView.inputCarNames().split(","));
                success = true;
            } catch (IllegalArgumentException e) {
                ErrorView.printError(e);
            }
        } while (!success);
    }

    private void setUpRoundNum() {
        boolean success = false;
        do {
            try {
                this.roundNum = Integer.parseInt(InputView.inputRoundNum());
                success = true;
            } catch (IllegalArgumentException e) {
                ErrorView.printError(e);
            }
        } while (!success);
    }

    private void runRound() {
        OutputView.printRoundResultInit();
        for (int i = 0; i < roundNum; i++) {
            OutputView.printRoundResult(carService.run());
        }
    }

    private void findWinner() {
        OutputView.printWinner(carService.findWinner());
    }
}
