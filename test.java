import java.util.*;  // Provides TreeMap, Iterator, Scanner  
import java.io.*;    // Provides FileReader, FileNotFoundException  

public class test {

    public static void main(String[] args) throws IOException {
    	DocList x = new DocList("src/data.csv");
    	invertIndex y = new invertIndex(x.getDocList());
    	System.out.println("Enter your search query: ");
    	Scanner scanner = new Scanner(System.in);
    	String q = scanner.nextLine();
    	invertIndex z = new invertIndex(q);

    	invertIndex sharedWords = z.sharedWords(y);
    	z.similarity(sharedWords);
    	List p = z.rankList(z.similarity(sharedWords));
    	System.out.println(p);
    	x.printArray(p);
    	scanner.close();
    }
    
    public static void printMap( Map<Integer, Integer> input ){ 
		for(Map.Entry<Integer, Integer> documentToFrequency : input.entrySet()) {
            Integer document = documentToFrequency.getKey();
            Integer wordCount = documentToFrequency.getValue();
           System.out.println( "Document " + document + " has a inner product of "+ wordCount);
		}
	}
}