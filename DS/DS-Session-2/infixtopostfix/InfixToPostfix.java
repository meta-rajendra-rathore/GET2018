package datastructure_2.infixtopostfix;

import datastructure_2.StackImplementation;

public class InfixToPostfix extends StackImplementation {
    private String result;
    
    public String convertToPostFix(String expression) {
        result = "";
        String[] listOfTokens = expression.split(" ");

        for (String token : listOfTokens) {
            if (token.matches("[a-z]*[A-Z]*[0-9]*")) {
                result += token;
            }

            else if (token.equals("(")) {
                push("(");
            }

            else if (peek() != null && token.equals(")")) {
                while (!(peek() == null || peek().equals("("))) {
                    result += pop();
                }

                if (peek() != null) {
                    pop();
                } else {
                    result = "Invalid expression!";
                    return result;
                }
            }

            else if (peek() != null && !peek().equals("(") && getPrecedence(peek()) >= getPrecedence(token)) {
                while (peek() != null && !peek().equals("(") && getPrecedence(peek()) >= getPrecedence(token)) {
                    result += pop();
                }
                push(token);
            }

            else {
                push(token);
            }
        }

        System.out.println(result);
        while (peek() != null) {
            result += pop();
        }
        
        return result;
    }

    public int getPrecedence(String operator) {
        switch (operator) {
        case "||":
            return 1;
        case "&&":
            return 2;
        case "==":
        case "!=":
            return 3;
        case "<":
        case ">":
        case "<=":
        case ">=":
            return 4;
        case "+":
        case "-":
            return 5;
        case "*":
        case "/":
            return 6;
        case "!":
        default:
            return 0;
        }
    }

    public String getResult() {
        return result;
    }

} // "a+b*(c^d-e)^(f+g*h)-i"; abcd^e-fgh*+^*+i-
