public class hw2_1
{public static String shuffle(String s, int[] index) {
    char[] shuffled = new char[s.length()];
    for (int i = 0; i < s.length(); i++) {
        shuffled[index[i]] = s.charAt(i);
    }
    return new String(shuffled);
}

public static void main(String[] args) {
    String s = "cba";
    int[] index = { 2, 1, 0 };
    String result = shuffle(s, index);
    System.out.println(result); // должно вывести "abc"
}
}
