package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("계산식을 입력하세요.");
            String value = sc.nextLine();
            System.out.println("입력한 계산식: " + value);

            int result = Calculator.calculate(value);
            System.out.println("결과 값: " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
