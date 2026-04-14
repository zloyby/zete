package by.zloy.interview;

import java.util.Stack;

/**
 * Java has a Stack implementation which provides the push(item) and pop() methods.
 * Create a MaxStack class that extends this class and adds a max() method that returns the largest element
 * in the MaxStack as an O(1) operation without damaging the Big-O complexity of the existing methods.
 */
public class MaxStack<T extends Comparable<T>> extends Stack<T> {

    private final Stack<T> maxStack = new Stack<T>();

    private T getMaxValue(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    @Override
    public T push(T item) {
        if (maxStack.empty()) {
            maxStack.push(item);
        } else {
            maxStack.push(getMaxValue(maxStack.peek(), item));
        }
        return super.push(item);
    }

    @Override
    public T pop() {
        maxStack.pop();
        return super.pop();
    }

    public T getMaxValue() {
        return maxStack.peek();
    }
}
