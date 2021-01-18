package introduction;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService service=Executors.newFixedThreadPool(1);
		Future<Integer> future=service.submit(new Callable<Integer>() {
			public Integer call(){
			return MyMath.add(10,20);
			}
		});
		
		while(!future.isDone())
			;
		System.out.println("Result:"+future.get());
	}

}

class MyMath{
	
	public static int add (int a,int b){
		return a+b;
	}
}