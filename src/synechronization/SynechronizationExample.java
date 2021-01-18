package synechronization;

public class SynechronizationExample {

	public static void main(String[] args) {

		Sample sample=new Sample();
		sample.setX(10);
		MySyncThread t1=new MySyncThread(sample);
		MySyncThread t2=new MySyncThread(sample);
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

class MySyncThread extends Thread{
	Sample obj;

	public MySyncThread(Sample obj) {
		this.obj = obj;
	}
	
	public void run(){
		obj.incr();
	}
	
}

class Sample{
	
	private int x;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public synchronized void incr(){
		int y=getX();
		y++;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setX(y);
		
	}
}