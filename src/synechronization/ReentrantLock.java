package synechronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantLock {

	public static void main(String[] args) {

		Sample1 sample = new Sample1();
		sample.setX(10);
		MySyncThread1 t1 = new MySyncThread1(sample);
		MySyncThread1 t2 = new MySyncThread1(sample);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(sample.getX());

	}

}

class MySyncThread1 extends Thread {
	Sample1 obj;

	public MySyncThread1(Sample1 obj) {
		this.obj = obj;
	}

	public void run() {
		obj.incr();
	}

}

class Sample1 {

	private int x;

	ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void incr() {
		Lock lock = readWriteLock.writeLock();
		try {
			lock.lock();
			int y = getX();
			y++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			setX(y);
		} finally {
			lock.unlock();
		}

	}
}
