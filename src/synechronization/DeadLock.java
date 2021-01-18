package synechronization;


class Writer1 extends Thread{
	
	Object book;
	Object pen;
	public Writer1(Object book, Object pen) {
		this.book = book;
		this.pen = pen;
	}
	public void run(){
		synchronized (book) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (pen) {
				System.out.println("Writer 1");
			}
		}
	}
	
	
}

class Writer2 extends Thread{
	
	Object book;
	Object pen;
	public Writer2(Object book, Object pen) {
		this.book = book;
		this.pen = pen;
	}
	public void run(){
		synchronized (book) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (pen) {
				System.out.println("Writer 2");
			}
		}
	}
	
	
}
public class DeadLock {

	public static void main(String[] args) {
		
		Object book=new Object();
		Object pen=new Object();
		
		new Writer1(book, pen).start();
		new Writer2(book, pen).start();
		
		System.out.println("main is done");
	}
}
