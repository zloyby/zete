package by.zloy.interview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxStackTest {

    private MaxStack maxStack = new MaxStack();

    @Test
    void getMaxValue() {
        maxStack.push(1);
        maxStack.push(3);
        maxStack.push(5);
        assertEquals(5, maxStack.getMaxValue()); //1,3,5

        maxStack.pop();
        assertEquals(3, maxStack.getMaxValue());//1,3

        maxStack.push(2);
        maxStack.push(9);
        maxStack.push(5);
        assertEquals(9, maxStack.getMaxValue());//1,3,2,9,5

        maxStack.pop();
        maxStack.pop();
        assertEquals(3, maxStack.getMaxValue());//1,3,2
    }
}