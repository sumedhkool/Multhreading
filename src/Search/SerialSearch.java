package Search;

import java.io.File;
import java.util.List;

public class SerialSearch {

	public static void main(String[] args) {
		String pattern="public";
		File dir = new File("./src/sample");
		 
		// list all the files present in the folder.
		File [] files = dir.listFiles();
			
		PatternFinder finder = new PatternFinder();
			
		long startTime = System.currentTimeMillis();
			
		// for each file in the list of files
	 
		for (File file : files) {
	 
		    List<Integer> lineNumbers = finder.finder(file, pattern);
	 
		    if (! lineNumbers.isEmpty()) {
			System.out.println(
	                    pattern + "; found at " + lineNumbers + 
	                    " in the file - " + file.getName());
		    }
				
		}
	}
}
