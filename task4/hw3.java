import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class hw3 {
    public static void main(String[] args) {
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(1, 2, 3));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(5, 4, 7));
        System.out.println(sum(d1, d2));
    }

    public static Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {
        Deque<Integer> result = new ArrayDeque<>();
        int carry = 0;

        while (!d1.isEmpty() || !d2.isEmpty()) {
             int sum = carry;
            sum += (d1.isEmpty()) ? 0 : d1.poll();
            sum += (d2.isEmpty()) ? 0 : d2.poll();
            result.add(sum % 10);
            carry = sum / 10;
        }

        if (carry > 0) {
            result.add(carry);
        }

        return result;
    }
}

