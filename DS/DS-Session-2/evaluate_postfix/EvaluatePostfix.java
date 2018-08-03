package datastructure_2.evaluate_postfix;

/**
 * This class evaluate any postfix expression using the stack interface
 * 
 * @author Rajendra Singh Rathore
 *
 */

import datastructure_2.StackImplementation;

public class EvaluatePostfix extends StackImplementation {
    private String inputExpression;
    private String result;

    public EvaluatePostfix(String expression) {
        this.inputExpression = expression;
    }
    
    public void evaluate() {
        String[] listOfTokens = inputExpression.split(" ");
        for (String token : listOfTokens) {
            if (token.matches("[0-9]+")) {
                push(token);
            } else {
                if (getNoOfItemInStack() >= 2) { 
                    String b = pop(), a = pop();
                    if (performOperation(a, b, token ) == null) {
                        result = "Invalid Expression!";
                        return;
                    } else {
                        push(performOperation(a, b, token));
                    }
                } else {
                    result = "Invalid Expression!";
                    return;
                }
            }
        }
        result = pop();
    }

    public String getResult() {
        return result;
    }

    public String performOperation(String a, String b, String operator) {
        switch (operator) {
        case "+":
            return "" + (Integer.parseInt(a) + Integer.parseInt(b));
        case "-":
            return "" + (Integer.parseInt(a) - Integer.parseInt(b));
        case "*":
            return "" + Integer.parseInt(a) * Integer.parseInt(b);
        case "/":
            if (Integer.parseInt(b) != 0)
                return "" + Integer.parseInt(a) / Integer.parseInt(b);
        }
        return null;
    }

}
