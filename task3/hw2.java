import java.util.ArrayList;
import java.util.Scanner;

public class hw2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите массив целых чисел через запятую: ");
        String input = sc.nextLine();

        String[] numbersAsString = input.split(",");
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        for (String numberAsString: numbersAsString) {
            int number = Integer.parseInt(numberAsString.trim());
            numbers.add(number);
        }

        numbers.removeIf(n -> n % 2 == 0);

        System.out.println("Результат: ");

        for (int i = 0; i < numbers.size(); i++) {
            if (i == numbers.size() - 1) {
                System.out.println(numbers.get(i));
            } else {
                System.out.print(numbers.get(i) + ", ");
            }
        }
    }
}