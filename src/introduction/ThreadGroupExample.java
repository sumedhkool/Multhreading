package introduction;

public class ThreadGroupExample {

	public static void main(String[] args) {
		ThreadGroup myGroup = new ThreadGroup("MyGroup");
		myGroup.setMaxPriority(4);
			
		Thread thread=new Thread(myGroup,new GroupExample(),"demo");
		thread.start();
		System.out.println("System threads..........");
		Thread thr = Thread.currentThread();
		ThreadGroup grp = thr.getThreadGroup();
		while (grp.getParent() != null) {
		    grp = grp.getParent();
		}
		grp.list();
	}

}

class GroupExample implements Runnable{

	@Override
	public void run() {
		System.out.println("Example");
	}
	
}