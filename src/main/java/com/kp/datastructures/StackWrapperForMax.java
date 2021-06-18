package com.kp.datastructures;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Enhance Stack to provide max element with O(1) complexity
 */
public abstract class StackWrapperForMax<V> {

    private Stack<V> stack = new Stack<V>();
    private Stack<V> maxStack = new Stack<V>();

    public abstract int compareTo(V value1, V value2);

    public void push(V i) {
        stack.push(i);
        if (maxStack.isEmpty() || compareTo(i,maxStack.peek()) <= 0) {
            maxStack.push(i);
        }
    }

    public V pop() {
        V poppedItem = stack.pop();
        if (!maxStack.isEmpty() && compareTo(maxStack.peek() , poppedItem ) == 0) {
            maxStack.pop();
        }
        return poppedItem;
    }

    public void printStacks(){
        System.out.print("Stack "+stack.toString()+"\t");
        System.out.println("Max Stack"+maxStack.toString());
    }

    public static void main(String[] args) {

        StackWrapperForMax<Integer> stackWrapperForMax = new StackWrapperForMax<Integer>() {
            @Override
            public int compareTo(Integer value1, Integer value2) {
                return value1.compareTo(value1);
            }
        };


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
