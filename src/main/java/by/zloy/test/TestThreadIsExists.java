package by.zloy.test;

public class TestThreadIsExists {
	public static void main(String[] args) {
		TestThreadIsExistsToRunInBackground t = new TestThreadIsExistsToRunInBackground();
		Thread thread = new Thread(t);
		System.out.println("Prepare thread");
		thread.start();
		System.out.println("Final string");
		//System.exit(0); // thread is fucked!
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
