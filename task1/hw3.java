import java.util.Scanner;

public class hw3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1, number2, result = 0;
        char operator;

        System.out.print("Введите первое число: ");
        number1 = scanner.nextInt();

        System.out.print("Введите второе число: ");
        number2 = scanner.nextInt();

        System.out.print("Введите оператор (+, -, *, /): ");
        operator = scanner.next().charAt(0);

        switch (operator) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                result = number1 / number2;
                break;
            default:
                System.out.println("Неправильный оператор");
                break;
        }

        System.out.println(number1 + " " + operator + " " + number2 + " = " + result);
    }
}