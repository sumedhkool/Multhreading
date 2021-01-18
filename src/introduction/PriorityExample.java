package introduction;


class CopyTask implements Runnable {
    @Override
    public void run() {
	while(true) {
	    System.out.println("C");
	}
    }
}
 
class ProgressTask implements Runnable {
    @Override
    public void run() {
	while(true) {
	    System.out.println("P");
	}
    }
}
 
public class PriorityExample {
 
    public static void main(String[] args) {
	CopyTask copyTask = new CopyTask();
	Thread copyThread = new Thread(copyTask);
	copyThread.setPriority(Thread.NORM_PRIORITY + 3);
	copyThread.start();
		
	ProgressTask progressTask = new ProgressTask();
	Thread progressThread = new Thread(progressTask);
	progressThread.start();
    }
}
