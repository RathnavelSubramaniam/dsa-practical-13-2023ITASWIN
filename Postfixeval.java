import java.io.*;
import java.util.*;
class stack
{
    int size;
    int item[];
    int top;
    public stack()
    {
        size = 100;
        item = new int[size];
        top = -1;
    }
    public void push(int ele)
    {
        if (top == (size - 1))
        {
            System.out.println("Stack Overflow");
        } else
        {
            top++;
            item[top] = ele;
          //  System.out.println("Inserted Element:"+ele);
        }
    }
    public int pop()
    {
        if (top == -1)
        {
            System.out.println("Invalid Postfix string; Operators are given more than operands");
            return (-1);
        } else
        {
            int x = item[top];
            top--;
          //  System.out.println("Popped Element:"+x);
            return (x);
        }
    }
    public int peek()
    {
        if (top == -1)
        {
            System.out.println("No Elements");
            return (-1);
        } else
            return (item[top]);
    }
    public void display()
    {
        System.out.println();
        if (top == -1)
        {
            System.out.println("No Elements");
        } else
        {
            System.out.println("Stack is");
            for (int i = 0; i <= top; i++)
                System.out.println(item[i]);
        }
    }
    public boolean isEmpty()
    {
        if(top==-1)
        return true;
        else
        return false;
    }
}
class evalpostfix
{
    stack st = new stack();
    String postfix;
    public evalpostfix(String str)
    {
        postfix = str;
    }
    public boolean isOperand(char ch)
    {
     
   return Character.isDigit(ch);
       
    }
    public int eval()
    {
        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);

            // If operand, push it to stack
            if (isOperand(ch)) {
                st.push(ch - '0');  // Convert char to int
            } else {
                // If operator, pop two elements from stack, apply operator and push result
                if (st.isEmpty()) {
                    System.out.println("Invalid Postfix Expression");
                    return -1;
                }
                int operand2 = st.pop();
                if (st.isEmpty()) {
                    System.out.println("Invalid Postfix Expression");
                    return -1;
                }
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
                        st.push(operand1 / operand2);
                        break;
                    default:
                        System.out.println("Invalid operator encountered: " + ch);
                        return -1;
                }
            }
        }

        // If everything is fine, the stack will have only one element which is the result
        if (st.isEmpty()) {
            System.out.println("Invalid Postfix Expression");
            return -1;
        }
        return st.pop();
    }
}
       
     
public class Postfixeval
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter postfix string");
        String str=sc.nextLine();
        evalpostfix epf = new evalpostfix(str);
        int res=epf.eval();
        if(res!=-1)
        System.out.println("Result:" +res);
       else
       System.out.println("Invlalid Postfix String");
    }
}

