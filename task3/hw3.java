import java.util.ArrayList;
import java.util.Scanner;

public class hw3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();

        // Ввод элементов в список
        System.out.println("Введите элементы списка (введите '0' для завершения ввода):");
        int input = 1;
        while (input != 0) {
            input = scanner.nextInt();
            if (input != 0) {
                list.add(input);
            }
        }

        // Находим минимальное, максимальное и среднее значения списка
        int min = list.get(0);
        int max = list.get(0);
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int current = list.get(i);
            if (current < min) {
                min = current;
            }
            if (current > max) {
                max = current;
            }
            sum += current;
        }
        double average = sum / list.size();

        // Выводим результаты через запятую
        System.out.println("Минимальное значение: " + min + ", максимальное значение: " + max + ", среднее значение: " + average);
    }
}