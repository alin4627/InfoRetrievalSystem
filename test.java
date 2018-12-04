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
    	z.innerProd(sharedWords);
    	scanner.close();
    }
    
   
}