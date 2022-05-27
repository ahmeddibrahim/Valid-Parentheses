package com.company;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        System.out.println("Please enter the parentheses expression you want to verify");
        Scanner in = new Scanner(System.in);
        String expression = in.nextLine();
        if(isValid(expression))
            System.out.println("Valid expression");
        else
            System.out.println("Not a valid expression");
    }

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else {
                if (stack.empty())
                    return false;
                else if (s.charAt(i) == ')' && stack.peek() == '(')
                    stack.pop();
                else if (s.charAt(i) == '}' && stack.peek() == '{')
                    stack.pop();
                else if (s.charAt(i) == ']' && stack.peek() == '[')
                    stack.pop();
                else
                    return false;
            }
        }

        if (stack.empty())
            return true;

        return false;
    }
}
