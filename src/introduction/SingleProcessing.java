package introduction;

public class SingleProcessing {

	 public static void main(String[] args) {
			
			// Print M's
			for(int i=1; i <= 15; i++) {
			    System.out.print("M");
			}
				
			// Call the task to print T's
			Task t1 = new Task();
			t1.doTask();
		    }
		 
}

class Task {
	 
    public void doTask() {
	for(int i=1; i <= 15; i++) {
	    System.out.print("T");
	}
    }
}