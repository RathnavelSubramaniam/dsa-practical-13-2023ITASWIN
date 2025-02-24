import java.io.*;
import java.util.*;

class Stack {
    int size;
    int item[];
    int top;

    public Stack() {
        size = 100;
        item = new int[size];
        top = -1;
    }

    public void push(int ele) {
        if (top == (size - 1)) {
            System.out.println("Stack Overflow");
        } else {
            top++;
            item[top] = ele;
        }
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Invalid Postfix string; Operators are given more than operands");
            return -1;
        } else {
            int x = item[top];
            top--;
            return x;
        }
    }

    public int peek() {
        if (top == -1) {
            System.out.println("No Elements");
            return -1;
        } else
            return item[top];
    }

    public void display() {
        System.out.println();
        if (top == -1) {
            System.out.println("No Elements");
        } else {
            System.out.println("Stack is");
            for (int i = 0; i <= top; i++)
                System.out.println(item[i]);
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

class EvalPostfix {
    Stack st = new Stack();
    String postfix;

    public EvalPostfix(String str) {
        postfix = str;
    }

    public boolean isOperand(char ch) {
        return Character.isDigit(ch); // Check if character is a digit
    }

    public int eval() {
        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);

            if (isOperand(ch)) {
                st.push(Character.getNumericValue(ch)); // Convert char to integer
            } else {
                // Operator case
                if (st.isEmpty()) return -1; // Invalid postfix expression

                int operand2 = st.pop();
                if (st.isEmpty()) return -1; // Invalid postfix expression

                int operand1 = st.pop();

                switch (ch) {
                    case '+':
                        st.push(operand1 + operand2);
                        break;
                    case '-':
                        st.push(operand1 - operand2);
                        break;
                    case '*':
                        st.push(operand1 * operand2);
                        break;
                    case '/':
                        if (operand2 == 0) {
                            System.out.println("Division by zero error");
                            return -1;
                        }
                        st.push(operand1 / operand2);
                        break;
                    default:
                        System.out.println("Invalid Operator: " + ch);
                        return -1;
                }
            }
        }

        if (!st.isEmpty()) {
            return st.pop();
        } else {
            return -1; // Invalid expression
        }
    }
}

public class Postfixeval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter postfix string:");
        String str = sc.nextLine();
        EvalPostfix epf = new EvalPostfix(str);
        int res = epf.eval();
        if (res != -1)
            System.out.println("Result: " + res);
        else
            System.out.println("Invalid Postfix String");
        sc.close();
    }
}
