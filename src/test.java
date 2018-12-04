import java.util.*;  // Provides TreeMap, Iterator, Scanner  
import java.io.*;    // Provides FileReader, FileNotFoundException  

public class test {

    public static void main(String[] args) throws IOException {
    	DocList x = new DocList("src/data.csv");
    	invertIndex y = new invertIndex(x.getDocList());
    	y.printMap();
    	
    }
    
   
}