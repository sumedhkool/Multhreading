package concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


// Producer...
class ProducerThread extends Thread {

	BlockingQueue<String> queue;

	public ProducerThread(BlockingQueue queue) {
		this.queue = queue;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			String msg = "Hello" + i;
			try {
				queue.put(msg);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Produce - " + msg);

		}
	}

}

// Consumer...
class ConsumerThread extends Thread {

	BlockingQueue<String> queue;

	public ConsumerThread(BlockingQueue queue) {
		this.queue = queue;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			String message;
			try {
				message = queue.take();
				System.out.println("Consumed - " + message);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}

public class ProducerConsumerWithBlockingQueue {
	// Main...

	public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
		new ProducerThread(queue).start();
		new ConsumerThread(queue).start();

	}

}