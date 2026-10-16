package by.zloy.poc.concurrency;

public class ThreadSyncCount {
    public static void main(String[] args) throws InterruptedException {

        Runnable task = new Runnable() {
            int count = 0; // Переменная привязана к конкретному экземпляру Runnable, передаем один объект в разные потоки

            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; i++) {
                    synchronized (this) { // чтобы инкремент count++ в каждый момент времени делал только один поток
                        count++; // race condition without sync
                    }
                }
                System.out.println(count);
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start(); //закончил свой цикл, вышел из него и выполняет строку System.out.println(count). В этот микромомент текущее значение count в памяти равно 1xxxxxx.
        t2.start(); //спокойно докручивает оставшиеся итерации своего цикла. Так как гонки данных на этапе инкремента не было, он гарантированно добьет значение count до финальных 2000000.
    }
}
