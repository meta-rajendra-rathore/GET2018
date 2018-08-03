package get_assignment1;

class Palindrome {
    char[] str = new char[100];
    int pointer;

    public void push(char ch) {
        str[pointer++] = ch;
    }

    public char pop() {
        return (str[--pointer]);
    }

    public boolean check() {
        int bottom = 0;
        for (int i = 0; i < pointer / 2; i++) {
            if (str[bottom++] == pop())
                continue;
            else
                return false;
        }
        return true;
    }
}

public class StackPalindrome {
    public static void main(String[] args) {
        String inputString;
        System.out.print("Enter the string : ");
        inputString = System.console().readLine();

        Palindrome palin = new Palindrome();
        for (int i = 0; i < inputString.length(); i++) {
            palin.push(inputString.charAt(i));
        }

        if (palin.check())
            System.out.println("The string is a palindrome.");
        else
            System.out.println("The string is not a palindrome!!!");
    }
}