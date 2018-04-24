package com.alayam.algorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/*
 * Logic behind this
 * dataSetIDMap is as hashmap contains datasetId(Key) -> (Value) List of DataCenters where datasetID is present
 */
public class MissingDataCenter {
	static HashMap<String,boolean[]> dataSetIDMap = new HashMap<String,boolean[]>();	

	//Building the dataSetID map from the given inputSet 
	public static void buildDataSetLookup(int numOfDataCenter, String[] inputList){
		Pattern pSpace = Pattern.compile("\\s");

		//Populate with initial position
		for(int i=0; i<inputList.length; ++i){

			String[] items = pSpace.split(inputList[i]);
			for(String s : items) {
				boolean[] dataCenterList;
				if(!dataSetIDMap.containsKey(s)){					
					dataCenterList = new boolean[numOfDataCenter];	
					dataSetIDMap.put(s, dataCenterList);

				}else{
					dataCenterList = dataSetIDMap.get(s);
				}
				dataCenterList[i] = true;

			}
		}
	}

	//Find and print the missing data-set Id's by iterating through the hashmap and
	//looking at the missing data center from the arrayList 
	public static void findAndPrintMissingList(){
		Iterator it = dataSetIDMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry)it.next();
			boolean[] dataCenterList = (boolean[]) pairs.getValue();
			String dataSetId = (String) pairs.getKey();
			int fromDataCenter = 0;
			for(int i=0;i<dataCenterList.length; i++){
				if(dataCenterList[i]){
					fromDataCenter = i;
					break;
				}
			}

			for(int i=0;i<dataCenterList.length; i++){
				if(!dataCenterList[i]){
					System.out.println(dataSetId+" "+(fromDataCenter+1)  +" "+(i+1));

				}
			}
		}
		System.out.println("done");

	}

	public static void test(String args[]){

		//all possible inputs from the eg:
		//		String inStr[] = {"1 3 4",
		//						"1 2 3",
		//						"1 3",
		//						"1 4 2"};
		//		

		//		String inStr[] = {"3 1 3 4",
		//		"3 1 2 3",
		//		"2 1 3",
		//		"3 1 4 2"};


		String inStr[] = {"5 1 3 4 5 7",
				"2 1 3",	
		"1 2"};		

		buildDataSetLookup(inStr.length,inStr);
		findAndPrintMissingList();


	}

	public static void main(String args[]){

		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));

		try {
			int numOfdataCenter = Integer.parseInt(br.readLine());
			String inStr[] = new String[numOfdataCenter];
			for(int i=0;i<numOfdataCenter; i++){
				inStr[i] = br.readLine();			
			}
			buildDataSetLookup(numOfdataCenter, inStr);
			findAndPrintMissingList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}