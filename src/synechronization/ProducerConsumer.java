package synechronization;

import java.util.ArrayList;
import java.util.List;

// MessageQueue ...
class MessageQueue {

	private List<String> messages;

	private int limit;

	public MessageQueue(int limit) {
		messages = new ArrayList<String>();
		this.limit = limit;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public boolean isFull() {
		return messages.size() == limit;
	}

	public boolean isEmpty() {
		return messages.isEmpty();
	}

	public synchronized void enqueue(String msg) {

		if (isFull()) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		messages.add(msg);
		this.notify();

	}

	public synchronized String dequeue() {

		if (isEmpty()) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		String message = messages.remove(0);
		this.notify();
		return message;

	}
}

// Producer...
class ProducerThread extends Thread {

	MessageQueue queue;

	public ProducerThread(MessageQueue queue) {
		this.queue = queue;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			String msg = "Hello" + i;
			queue.enqueue(msg);
			System.out.println("Produce - " + msg);

		}
	}

}

// Consumer...
class ConsumerThread extends Thread {

	MessageQueue queue;

	public ConsumerThread(MessageQueue queue) {
		this.queue = queue;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			String message = queue.dequeue();
			System.out.println("Consumed - " + message);

		}
	}

}

// Main...
public class ProducerConsumer {

	public static void main(String[] args) {
		MessageQueue messageQueue = new MessageQueue(1);
		new ProducerThread(messageQueue).start();
		new ConsumerThread(messageQueue).start();

	}

}