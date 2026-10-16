package by.zloy.interview;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.All)
public class MaxStackTest {

    private final MaxStack maxStack = new MaxStack();

    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 20)
    @Benchmark
    @Test
    public void getMaxValue() {
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