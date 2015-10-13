package algorithm;

import java.util.ArrayList;
import java.util.List;

public class DecodeAndEncode {

	public static void main(String[] args){
		List<String> strs = new ArrayList<String>();
		strs.add("");
		strs.add("sky");
		strs.add("is");
		strs.add("blue");
		strs.add("3#");
		strs.add("#");
		strs.add("0123456789");
		
		String encodeStr = encode(strs);
		System.out.println(encodeStr);
		System.out.println(decode(encodeStr));
		
	}
	
    public static String encode(List<String> strs) {
    	StringBuilder sb = new StringBuilder();
    	
    	for(String s : strs){
    		sb.append(s.length());
    		sb.append('#');
    		sb.append(s);
    	}
    	
    	return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {
    	List<String> strs = new ArrayList<String>();
    	
    	int i=0; 
    	while(i<s.length()){
    		StringBuilder strlen = new StringBuilder();
    		while(Character.isDigit(s.charAt(i))){
    			strlen.append(s.charAt(i));
    			i++;
    		}
    		
    		int len = Integer.parseInt(strlen.toString());
    		strs.add(s.substring(i+1,i+1+len));
    		i=i+1+len;
    	}
    	
    	
        return strs;
    }
}
