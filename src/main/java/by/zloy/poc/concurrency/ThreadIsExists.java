package by.zloy.poc.concurrency;

public class ThreadIsExists {

    public static void main(String[] args) throws InterruptedException {
        TestThreadIsExistsToRunInBackground t = new TestThreadIsExistsToRunInBackground();
        Thread thread = new Thread(t);
        //thread.setDaemon(true); // if daemon - exit with application immediately
        System.out.println("Prepare thread");
        thread.start();
        System.out.println("Final string");
        //System.exit(0); // if exit(0) - exit with application immediately
    }

    static class TestThreadIsExistsToRunInBackground implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("Thread begins working");
                Thread.sleep(5000);
                System.out.println("Thread ends working");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
