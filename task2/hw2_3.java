import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

public class hw2_3 {

    private static final Logger LOGGER = Logger.getLogger(hw2_3.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число в формате byte: ");

        byte b = scanner.nextByte();
        scanner.nextLine(); // очистка буфера

        try (FileWriter writer = new FileWriter("result.txt")) {
            writer.write(Byte.toString(b));
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Не удалось записать число в файл", e);
            return;
        }

        LOGGER.info("Число успешно записано в файл 'result.txt'");
    }
}