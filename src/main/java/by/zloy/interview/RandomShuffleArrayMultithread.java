package by.zloy.interview;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomShuffleArrayMultithread<T> {

    private final T[] array;
    private final AtomicInteger index;
    private final Semaphore semaphore;

    public RandomShuffleArrayMultithread(T[] array) {
        this.array = array;
        index = new AtomicInteger(0);
        semaphore = new Semaphore(0);
    }

    public static void main(String[] args) {
        Integer[] list = {1, 2, 3, 4, 5, 6, 16, 15, 14, 13, 12, 11};
        RandomShuffleArrayMultithread<Integer> randomShuffle = new RandomShuffleArrayMultithread<>(list);
        System.out.println(randomShuffle.getAllAsString());
        randomShuffle.startShuffling();
        System.out.println(randomShuffle.getAllAsString());

    }

    public void startShuffling() {
        Random random = new Random();
        for (int source = 0; source < array.length; ++source) {
            int target = random.nextInt(array.length - source) + source;
            T temp = array[target];
            array[target] = array[source];
            array[source] = temp;
            semaphore.release();
        }
    }

    public T getNext() throws InterruptedException {
        semaphore.acquire();
        int ind = index.getAndIncrement();
        return array[ind];
    }

    public String getAllAsString() {
        return Stream.of(array).map(Object::toString).collect(Collectors.joining(","));
    }
}
