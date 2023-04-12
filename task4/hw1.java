//не пойму где косяк
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class hw1 {
    public static boolean checkOn(Deque deque) {
        Deque reversedDeque = new ArrayDeque<>();
            for (int i : deque) {
            reversedDeque.push(i);
        }
        while (!deque.isEmpty()) {
            if (!deque.removeFirst().equals(reversedDeque.removeFirst())) {
            return false;
            }
        }
    return true;
    }
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>(Arrays.asList(1,2,3,4,5,6));
        System.out.println(checkOn(deque)); // false
        Deque<Integer> deque2 = new ArrayDeque<>(Arrays.asList(1,2,3,3,2,1));
        System.out.println(checkOn(deque2)); // true
        Deque<Integer> deque3 = new ArrayDeque<>(Arrays.asList(4,5,6,6,5,4));
        System.out.println(checkOn(deque3)); // true
    }
}