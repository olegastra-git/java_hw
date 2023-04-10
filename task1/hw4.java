import java.util.Scanner;

public class hw4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите уравнение: ");
        String equationString = scanner.nextLine();
        scanner.close();

        equationString = equationString.replaceAll("\\s", ""); // удаляем пробелы

        // Получаем левую и правую части уравнения
        String[] equationParts = equationString.split("=");
        String leftPart = equationParts[0];
        String rightPart = equationParts[1];

        // Получаем переменные и знаки вопроса
        int q = -1, w = -1, e = -1;
        for (int i = 0; i < leftPart.length(); i++) {
            char ch = leftPart.charAt(i);
            if (ch == '?') {
                continue;
            }
            int digit = Character.getNumericValue(ch);
            if (i == 0) {
                q = digit;
            } else {
                w = digit;
            }
        }
        for (int i = 0; i < rightPart.length(); i++) {
            char ch = rightPart.charAt(i);
            if (ch == '?') {
                continue;
            }
            e = Character.getNumericValue(ch);
        }

        // Перебираем все возможные значения переменных
        for (int i = 0; i < 10; i++) {
            if (q != -1 && q != i) {
                continue;
            }
            for (int j = 0; j < 10; j++) {
                if (w != -1 && w != j) {
                    continue;
                }
                for (int k = 0; k < 10; k++) {
                    if (e != -1 && e != k) {
                        continue;
                    }
                    if ((q == -1 || q == i) && (w == -1 || w == j) && (e == -1 || e == k) && i + j == k) {
                        // Найдено верное решение
                        String solution = leftPart.replaceAll("\\?", Integer.toString(i)) + " = " + rightPart.replaceAll("\\?", Integer.toString(j));
                        System.out.println("Решение: " + solution);
                        return;
                    }
                }
            }
        }

        // Решение не найдено
        System.out.println("Решения не существует.");
    }
}
//Для проверки примера 2?+?5=50 нужно передать в программу строку "2?+?5=50".