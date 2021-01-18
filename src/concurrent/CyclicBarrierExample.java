package concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class A extends Thread {

	CyclicBarrier barrier;

	public A(CyclicBarrier barrier) {
		super();
		this.barrier = barrier;
	}

	public void run() {

		try {
			barrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("A begins");

	}

}

class B extends Thread {

	CyclicBarrier barrier;

	public B(CyclicBarrier barrier) {
		super();
		this.barrier = barrier;
	}

	public void run() {
		try {
			barrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("B begins");
	}

}

public class CyclicBarrierExample {

	public static void main(String[] args) {

		CyclicBarrier barrier = new CyclicBarrier(2);
		new A(barrier).start();
		new B(barrier).start();
	}

}
