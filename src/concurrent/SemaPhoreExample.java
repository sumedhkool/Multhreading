package concurrent;

import java.util.concurrent.Semaphore;

class SemaphoreDemo extends Thread{
	
	Semaphore semaphore;
	
	public SemaphoreDemo(Semaphore semaphore) {
		super();
		this.semaphore = semaphore;
	}

	public void run(){
		try {
			semaphore.acquire();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Printing start");
		semaphore.release();
	}
}

public class SemaPhoreExample {

	public static void main(String[] args) {
		Semaphore semaphore=new Semaphore(3);
		
		new SemaphoreDemo(semaphore).start();
		new SemaphoreDemo(semaphore).start();
		new SemaphoreDemo(semaphore).start();
		new SemaphoreDemo(semaphore).start();
		new SemaphoreDemo(semaphore).start();

	}

}
