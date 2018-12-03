import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DocList extends ArrayList<Document>{

	public List<Document> DocList;
	
	public DocList( String input )throws IOException {
    	Scanner scanner = new Scanner(new File(input));
    	Scanner valueScanner = null;
    	int index = 0;
    	this.DocList = new ArrayList<>();
    	scanner.nextLine();
    	while (scanner.hasNextLine()) {
    	    valueScanner = new Scanner(scanner.nextLine());
    	    valueScanner.useDelimiter(",");
    	    Document entry = new Document();

    	    while (valueScanner.hasNext()) {
    		String data = valueScanner.next().toLowerCase();
    		data = data.replaceAll("\\p{Punct}", "");
    		if (index == 0){
    			entry.setID(Integer.parseInt(data));
    		}
    		else if (index == 1){
    			entry.setAPP_Name(data);
    		}
    		else if (index == 2){
    			entry.setGenre(data);
    		}
    		else if (index == 3){
    			entry.setPrice(data);
    		}
    		else if (index == 4){
    			entry.setUser_Rating(data);
    		}
    		else if (index == 5){
    			entry.setTotalReviews(data);
    		}
    		else if (index == 6){
    			entry.setUserReview(data);
    		}
    		index++;
    	    }
    	    index = 0;
    	    this.DocList.add(entry);
    	   
    	}

    	scanner.close();
    }
	
	public List<Document> getDocList()
	{
		return this.DocList;
	}
}
