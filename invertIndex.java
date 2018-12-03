import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class invertIndex {
	
			public Map<String, Map<Integer, Integer>> wordToDocumentMap;
			
			public invertIndex( List<Document> input ) throws IOException{
				wordToDocumentMap = new LinkedHashMap<String, Map<Integer, Integer>>();
				int currentDocID;
		    	for(int i = 0; i < input.size()-1; i++){
		    	String currentDocument = input.get(i).getUserReview();
		    	currentDocID = input.get(i).getID();
		    	String[] listWords = currentDocument.split(" ");
		    
			    	for (int k = 0; k < listWords.length; k++){
			    	String currentWord = listWords[k];
			    	Map<Integer, Integer> documentToCountMap;
				    	if (!(wordToDocumentMap.containsKey(currentWord))){
				    		 // This word has not been found anywhere before,
				    	    // so create a Map to hold document-map counts.
				    	    documentToCountMap = new LinkedHashMap<>();
				    	    wordToDocumentMap.put(currentWord, documentToCountMap);
				    	}
				    	
				    	documentToCountMap = wordToDocumentMap.get(currentWord);
				    	Integer currentCount = documentToCountMap.get(currentDocID);
				    	if(currentCount == null) {
				    	    // This word has not been found in this document before, so
				    	    // set the initial count to zero.
				    	    currentCount = 0;
				    	}
				    	documentToCountMap.put(currentDocID, currentCount + 1);
				    	
			    	}
		    	
			    	}
		    	}
			
				public void printMap(){
					for(Map.Entry<String, Map<Integer,Integer>> wordToDocument :
				        wordToDocumentMap.entrySet()) {
				        String currentWord = wordToDocument.getKey();
				        Map<Integer, Integer> documentToWordCount = wordToDocument.getValue();
					        for(Map.Entry<Integer, Integer> documentToFrequency : documentToWordCount.entrySet()) {
					            Integer document = documentToFrequency.getKey();
					            Integer wordCount = documentToFrequency.getValue();
					           System.out.println("Word: " + currentWord + "| found " + wordCount +
					                 " times in document " + document);
					        }
						}
				}
}


