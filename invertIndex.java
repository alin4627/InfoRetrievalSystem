import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class invertIndex {
	
			public Map<String, Map<Integer, Integer>> wordToDocumentMap;
			
			
			public invertIndex( List<Document> input ) throws IOException{
				wordToDocumentMap = new LinkedHashMap<String, Map<Integer, Integer>>();
				int currentDocID;
		    	for(int i = 0; i < input.size(); i++){
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
			
			
			
			public invertIndex( String input ) throws IOException{
				wordToDocumentMap = new LinkedHashMap<String, Map<Integer, Integer>>();

		    	String[] listWords = input.split(" ");
		    	 	int currentDocID = 0;
			    	for (int k = 0; k < listWords.length; k++){
			    	String currentWord = listWords[k];
			    	currentWord = currentWord.toLowerCase();
			    	currentWord = currentWord.replaceAll("\\p{Punct}", "");
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
			
			public invertIndex( Map<String, Map<Integer,Integer>> x ){
				wordToDocumentMap = x;
			}

			public invertIndex sharedWords( invertIndex i1 ){
				Map<String, Map<Integer,Integer>> mapr = new LinkedHashMap<String, Map<Integer,Integer>>();
				invertIndex output = new invertIndex(mapr);
					for (Map.Entry<String, Map<Integer,Integer>> wordinQuery:  wordToDocumentMap.entrySet()){
						String currentWord = wordinQuery.getKey();
						Map<Integer, Integer> qWordCount = wordinQuery.getValue();
						for( Map.Entry<String, Map<Integer,Integer>> wordinIndex: i1.getMap().entrySet()){
							String storedWords = wordinIndex.getKey();
							Map<Integer, Integer> documentsWordCount = wordinIndex.getValue();
							if(currentWord.equals(storedWords)){
								mapr.put(currentWord, documentsWordCount);
								output.getMap().putAll(mapr);
							}
						}
						
					}
				return output;	
			}
			
			public Map<Integer,Integer> innerProd( invertIndex input ){
				Map<Integer,Integer> output = new LinkedHashMap<Integer,Integer>();
				for (Map.Entry<String, Map<Integer,Integer>> wordinQuery:  wordToDocumentMap.entrySet()){
					String currentWord =  wordinQuery.getKey();
					Map<Integer, Integer> qWordCount = wordinQuery.getValue();
					for( Map.Entry<String, Map<Integer,Integer>> wordinIndex: input.getMap().entrySet()){
						String storedWords = wordinIndex.getKey();
						Map<Integer, Integer> documentsWordCount = wordinIndex.getValue();
						for(Map.Entry<Integer, Integer> documentToFrequency : documentsWordCount.entrySet()) {
							if(currentWord.equals(storedWords)){
								Integer q1 = qWordCount.get(0);
								//System.out.println("query wordcount:" + q1);
								Integer d1 = documentToFrequency.getKey();
								//System.out.println("document:" + d1);
								Integer m1 = documentToFrequency.getValue();
								//System.out.println("wordcount:" + m1);
								Integer currentCount = output.get(d1);
								//System.out.println("currentCount: "+currentCount);
						    	if(currentCount == null) {
						    	    currentCount = 0;
						    //	    System.out.println("currentCount after null: "+currentCount);
						    	}
								if (q1>0 && m1>0){
									currentCount = currentCount+1;
									output.put(d1, currentCount);
							//		System.out.println("currentCount in output: "+currentCount);
								}
							}
				
						}
					}
				}
				for(Map.Entry<Integer, Integer> documentToFrequency : output.entrySet()) {
		            Integer document = documentToFrequency.getKey();
		            Integer wordCount = documentToFrequency.getValue();
		           System.out.println( "Document " + document + " has a inner product of "+ wordCount);
		        }
				
				return output;
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
				
			public Map<String, Map<Integer, Integer>> getMap(){
					return wordToDocumentMap;
			}
				
				
}


