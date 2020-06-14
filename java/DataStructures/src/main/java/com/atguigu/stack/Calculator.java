package com.atguigu.stack;

public class Calculator {
    public static void main(String[] args) {


        String expression = "7-2*6+2";
        ArrayStack1 numStack1 = new ArrayStack1(10);
        ArrayStack1 operStack = new ArrayStack1(10);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            if (operStack.isOper(ch)) {
                if (!operStack.isEmpty()) {
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num2 = numStack1.pop();
                        num1 = numStack1.pop();
                        oper = operStack.pop();
                        res = numStack1.cal(num1, num2, oper);
                        numStack1.push(res);
                        operStack.push(ch);

                    } else {
                        operStack.push(ch);
                    }
                } else {
                    operStack.push(ch);
                }

            } else {
                numStack1.push(ch - 48);
            }
            index++;
            if (index >= expression.length()) {
                break;
            }

        }
        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack1.pop();
            num2 = numStack1.pop();
            oper = operStack.pop();
            res = numStack1.cal(num2, num1, oper);
            numStack1.push(res);
        }
        System.out.printf("结果是 %d\n", res);
    }
}

class ArrayStack1 {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack1(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("当前栈已满");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("当前栈已空");
            throw new RuntimeException("当前栈已满");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("当前栈已空");
            throw new RuntimeException("当前栈已满");
        }
        return stack[top];
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈空,没有数据");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }


    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;

        } else {
            return -1;
        }
    }

    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num1 / num2;
                break;
            default:
                break;
        }
        return res;

    }

}
