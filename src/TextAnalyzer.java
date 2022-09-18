import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TextAnalyzer {
	static void countFrequencies(String fileName, Map<String, Integer> stats) throws FileNotFoundException {
		Scanner file = new Scanner(new File(fileName));
		while (file.hasNext()) {
			String word = file.next();
			Integer count = stats.get(word);
			if (count != null)
				count++;
			else
				count = 1;
			stats.put(word, count);
		}
	     file.close();

	}

	public static void main(String[] args) throws FileNotFoundException {
		Map<String, Integer> stats = new HashMap<String, Integer>();
		
		  countFrequencies("C:\\Users\\fatim\\eclipse-workspace\\SDLC Assignment\\TheRavenPoem.txt" , stats);
		  System.out.println(" The Reven Poem Words and their frequencies sorted ");
		  stats.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue()
                  .reversed().thenComparing(Map.Entry.comparingByKey())).forEach(System.out::println);

	}

}
