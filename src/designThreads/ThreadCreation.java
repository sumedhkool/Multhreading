package designThreads;

public class ThreadCreation {

	public static void main(String[] args) {
		MyTask myTask = new MyTask();
		myTask.start();

		MyTask1 myTask1 = new MyTask1();
		Thread thread = new Thread(myTask1);
		thread.start();
		for (int i = 1; i <= 150; i++) {
			System.out.print("M");
		}
	}

}

class MyTask extends Thread {

	public void run() {
		for (int i = 1; i <= 150; i++) {
			System.out.print("T");
		}
	}

}

class MyTask1 implements Runnable {

	public void run() {
		for (int i = 1; i <= 150; i++) {
			System.out.print("R");
		}
	}

}
