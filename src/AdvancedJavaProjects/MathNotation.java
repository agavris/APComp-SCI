package AdvancedJavaProjects;

import java.util.Stack;


public class MathNotation {
    public static int getPrecedence(char c) {
        return switch (c) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    public static String convert_to_infix(String s) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                postfix.append(c);
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                if(stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if(getPrecedence(c) > getPrecedence(stack.peek())) {
                        stack.push(c);
                    } else {
                        postfix.append(stack.pop());
                        stack.push(c);
                    }
                }
            }
        }
        while(!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }
    public static void main(String[] args) {
        System.out.println(convert_to_infix("5 + 4 * 8 – 3 / 23"));
    }

}
