package easy.other;

import java.util.*;

/**
 * Created by deep20jain on 23-03-2018.
 */
public class ValidParenthesis {

    public boolean isValid_better(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for(char c: s.toCharArray()) {
            if(c == '(')
                deque.push(')');
            else if(c == '{')
                deque.push('}');
            else if(c == '[')
                deque.push(']');
            else if(deque.isEmpty() || deque.pop()!=c)
                return false;
        }
        return deque.isEmpty();
    }

    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c: s.toCharArray()) {
            if(isOpening(c)) {
                deque.push(c);
                continue;
            }

            if(isClosing(c) && !deque.isEmpty() && deque.peek()==getOpening(c)) {
                deque.pop();
                continue;
            }

            return false;
        }
        return deque.isEmpty();
    }

    private char getOpening(char c) {
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        return map.get(c);
    }

    private boolean isOpening(char c){
        if (c == '{' || c == '(' || c == '[') {
            return true;
        }
        return false;
    }

    private boolean isClosing(char c) {
        if (c=='}' || c==')' || c==']') {
            return true;
        }
        return false;
    }
}
