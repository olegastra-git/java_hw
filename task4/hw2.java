import java.util.Deque;
import java.util.LinkedList;

public class hw2 {
    public static void main(String[] args) {
        boolean res1 = validate("()[]"); 
        boolean res2 = validate("()"); 
        boolean res3 = validate("{[()]}");
        boolean res4 = validate("()()"); 
        boolean res5 = validate(")()("); 
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
        System.out.println(res5);
    }

    public static boolean validate(String str){
        Deque<Character> deque = new LinkedList<>();
        for(char c : str.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
              deque.push(c);
         }
         else{
              if(deque.isEmpty()){
                 return false;
             }
             char last = deque.pop();
             if((last == '(' && c != ')') || (last == '{' && c != '}') || (last == '[' && c != ']')){
                    return false;
            }
         }
     }
    return deque.isEmpty();
 }
}