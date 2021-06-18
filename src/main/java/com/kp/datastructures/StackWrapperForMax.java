package com.kp.datastructures;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StackWrapperForMax {

    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> maxStack = new Stack<Integer>();

    public void push(int i) {
        stack.push(i);
        if (maxStack.isEmpty() || maxStack.peek() <= i) {
            maxStack.push(i);
        }
    }

    public int pop() {
        int poppedItem = stack.pop();
        if (!maxStack.isEmpty() && maxStack.peek() == poppedItem) {
            maxStack.pop();
        }
        return poppedItem;
    }

    public void printStacks(){
        System.out.println("Stack "+stack.toString());
        System.out.println("Max Stack"+maxStack.toString());
    }

    public static void main(String[] args) {

        StackWrapperForMax stackWrapperForMax = new StackWrapperForMax();
        List<Integer> stackElements = Arrays.asList(5, 2, 3, 7, 7, 4);

        stackElements.stream().forEach(x -> {
                    stackWrapperForMax.push(x);
                    stackWrapperForMax.printStacks();

                }
        );

        stackElements.stream().forEach(x -> {
                    stackWrapperForMax.pop();
                    stackWrapperForMax.printStacks();

                }
        );
    }
}
