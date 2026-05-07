package by.zloy.interview;

public class ThreadDeadlock {

    public static void main(String[] args) {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");
        new Thread(() -> alphonse.bow(gaston)).start();
        new Thread(() -> gaston.bow(alphonse)).start();
    }

    record Friend(String name) {

        public synchronized void bow(Friend bower) {
            System.out.format("bow: %s: %s \n", this.name, bower.name());
            bower.bowBack(this);
        }

        public synchronized void bowBack(Friend bower) {
            System.out.format("bowBack: %s: %s \n", this.name, bower.name());
        }
    }
}
