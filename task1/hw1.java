import java.util.Scanner;

public class hw1 {
    public static void main(String[] args) {
        int[] cubes = new int[1000];
        for (int i = 0; i < cubes.length; i++) {
            cubes[i] = (i + 1) * (i + 1) * (i + 1);
        }

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(cubes[a-1]);
        System.out.println(cubes[b-1]);
    }
}