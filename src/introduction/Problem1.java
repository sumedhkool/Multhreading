package introduction;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]={10,20,30,40,50,60,70,80,90};
		int start=0;
		int end=3;
		ExecutorService executorService=Executors.newFixedThreadPool(3);
		Future<Integer> future=executorService.submit(new Callable<Integer>() {
			
			public Integer call(){
				return Calculate.getSum(arr, end,start);
				
			}
		});
		
	}

}


class Calculate {
	
	 public static Integer getSum(int arr[],int end,int start){
		 int sum=0;
		 for (int i = start; i < end; i++) {
			sum+=arr[0];
		}
		return sum;
	 }
}
