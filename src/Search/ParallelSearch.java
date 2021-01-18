package Search;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelSearch {

	public static void main(String[] args) throws Exception {

		String pattern = "public";

		File dir = new File("./src/sample");

		// list all the files present in the folder.
		File[] files = dir.listFiles();

		PatternFinder finder = new PatternFinder();

		ExecutorService executorService = Executors.newFixedThreadPool(3);

		Map<String, Object> result = new HashMap<String, Object>();
		long startTime = System.currentTimeMillis();
		
		for (File file : files) {
			Future<List<Integer>> future = executorService.submit(new Callable<List<Integer>>() {
				public List<Integer> call() {
					return finder.finder(file, pattern);
				}
			});

			result.put(file.getName(), future);
		}
		
		
		// Wait for the requests to complete.
		waitForAll( result);
			
		// Display the result.
		for (Map.Entry<String, Object> entry : result.entrySet()) {
			System.out.println( 
	                    pattern + " found at - " + entry.getValue() + 
	                    " in file " + entry.getKey());
		}
		System.out.println(
	            " Time taken for search - "  
	            + (System.currentTimeMillis() - startTime));
			
		executorService.shutdown();
	}

	private static void waitForAll(Map<String, Object> resultMap) throws Exception {

		Set<String> keys = resultMap.keySet();

		for (String key : keys) {
			Future<List<Integer>> future = (Future<List<Integer>>) resultMap.get(key);

			while (!future.isDone()) {

				// Passing the CPU to other
				// threads so that they can
				// complete the operation.
				// With out this we are simply
				// keeping the CPU in loop and
				// wasting its time.

				Thread.yield();
			}

			// Replace the future object with the obtained result.
			resultMap.put(key, future.get());
		}

	}
}
