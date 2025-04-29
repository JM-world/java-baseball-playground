package baseball.controller;

import baseball.domain.SecretNumberCreator;

import java.util.List;

public class BaseballController {
    public static void main(String[] args) {
        List<Integer> computerNumber = SecretNumberCreator.create();
        System.out.println("computerNumber: " + computerNumber);
    }
}
