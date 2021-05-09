package com.practice.interview.arcesium;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class FilterJSONResponseOnCriteria {

    /*
     * Complete the 'apiResponseParser' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY inputList
     *  2. INTEGER size
     */
	
	public static void main(String[] args) {
		List<String> inputList1 = new ArrayList<String>();
		inputList1.add("username");
		inputList1.add("IN");
		inputList1.add("vinayk");
		System.out.println(apiResponseParser(inputList1,3));
		
		List<String> inputList2 = new ArrayList<String>();
		inputList2.add("address.city");
		inputList2.add("IN");
		inputList2.add("Mumbai,Kolkata");
		System.out.println(apiResponseParser(inputList2,3));
		
		List<String> inputList3 = new ArrayList<String>();
		inputList3.add("username");
		inputList3.add("EQUALS");
		inputList3.add("Tom");
		System.out.println(apiResponseParser(inputList3,3));
		
	}

    public static List<Integer> apiResponseParser(List<String> inputList, int size) {
       String strURL = "https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users";
       ArrayList<String> attributes  = readURL(strURL);
       ArrayList<String> patterns = prepareSearchPattern(inputList);
       
       List<Integer> result = new ArrayList<Integer>();
       
       for(String pattern : patterns){
           String idString = "";
           String idMatched="";
           for(int i=0; i<attributes.size(); i++){
               if(attributes.get(i).contains("\"id\":")){
                   idString = attributes.get(i);
               }
               if(attributes.get(i).contains(pattern)){
            	   idMatched = idString;
                   break;
               }
           }
           if(idMatched != ""){
                Integer id = Integer.parseInt((idString.split(":")[1]).trim());
                result.add(id);    
           }
       }
       if(result.size() == 0){
           result.add(-1);
       }
       
       return result;
        
    }
    
    private static ArrayList<String> prepareSearchPattern(List<String> inputList){
        //Size is always 3;
        StringBuilder pattern = new StringBuilder();
        ArrayList<String> patterns = new ArrayList<>();
        
        // if key is in address.city format, converting to "city":"value"
        String key = inputList.get(0);
        if(key.contains(".")){
            String[] arr = key.split("\\.");
            key = arr[arr.length-1]; //getting last split, address.city -> city
        }
        
        if(inputList.get(1) == "EQUALS"){
            pattern.append("\"").append(key).append("\"").append(": ").append("\"").append(inputList.get(2)).append("\"");
            patterns.add(pattern.toString());
        }else{//This is for IN
            String[] values = inputList.get(2).split(",");
            for(String value : values){
                pattern.append("\"").append(key).append("\"").append(": ").append("\"").append(value).append("\"");
            patterns.add(pattern.toString());
            pattern.setLength(0);
            }
        }
        return patterns;
    }
    
    private static ArrayList<String> readURL(String strURL){
        BufferedReader in;
        String line;
        ArrayList<String> attributes = null;
        try{
            //Read JSON url
            URL url = new URL(strURL);
            InputStreamReader isr = new InputStreamReader(url.openStream());
            in = new BufferedReader(isr);
            attributes = new ArrayList<>();
            while((line = in.readLine()) != null){
                attributes.addAll(Arrays.asList(line.split(",")));  
            }  
        in.close();
        }catch(Exception e){
            System.err.print("Error while reading URL");
        }
        return attributes;
    }

}