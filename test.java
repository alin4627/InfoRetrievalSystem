import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {

    public static void main(String[] args) throws IOException {
	Scanner scanner = new Scanner(new File("src/data.csv"));
	Scanner valueScanner = null;
	int index = 0;
	List<Document> DocList = new ArrayList<>();
	scanner.nextLine();
	while (scanner.hasNextLine()) {
	    valueScanner = new Scanner(scanner.nextLine());
	    valueScanner.useDelimiter(",");
	    Document entry = new Document();

	    while (valueScanner.hasNext()) {
		String data = valueScanner.next();
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
			entry.setUser_Rating(Double.parseDouble(data));
		}
		else if (index == 5){
			entry.setTotalReviews(Integer.parseInt(data));
		}
		else if (index == 6){
			entry.setUserReview(data);
		}
		index++;
	    }
	    index = 0;
	    DocList.add(entry);
	}

	scanner.close();

	System.out.println(DocList);

    }

}