package introduction;

public class StoppingThread {

	public static void main(String[] args) {
      StopThread stopThread=new StopThread();
      stopThread.start();
      
      try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		stopThread.interrupt();
	}

}

class StopThread extends Thread{
	public void run(){
		for(;;){
			System.out.println("T");
			if(interrupted()){
				System.out.println("Is interupted");
				break;
			}
		}
	}
}
