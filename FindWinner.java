package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class FindWinner {

	public static void main(String[] args){
	
		Vector<LogEntry> logs = new Vector<LogEntry>();
		logs.add(new LogEntry("c1",1));
		logs.add(new LogEntry("c2",2));
		logs.add(new LogEntry("c1",2));
		logs.add(new LogEntry("c2",3));
		logs.add(new LogEntry("c2",4));
		logs.add(new LogEntry("c3",3));
		logs.add(new LogEntry("c4",3));
		logs.add(new LogEntry("c4",3));
		logs.add(new LogEntry("c4",3));
		logs.add(new LogEntry("c4",3));
		logs.add(new LogEntry("c4",3));
		
		//System.out.println(findWinner(4,logs));
		System.out.println(findTopKWinner(4,logs,2));
	}
	
	public static class LogEntry{
		String candidate;
		int time;
		public LogEntry(String c, int t	){
			candidate = c;
			time = t;
		}
	}
	
	public static String findWinner(int time, Vector<LogEntry> logs){
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		for(LogEntry log : logs){
			if( log.time<=time){
				if(map.containsKey(log.candidate)) map.put(log.candidate, map.get(log.candidate)+1);
				else map.put(log.candidate,1);
			}
		}
		
		String winner = "";
		int max = 0;
		for(String str : map.keySet()){
			if(map.get(str)>max){
				max = map.get(str);
				winner = str;
			}
		}
		
		return winner;
	}
	
	public static List<String> findTopKWinner(int time, Vector<LogEntry> logs, int k){
		List<String> result = new ArrayList<String>();
		
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		for(LogEntry log : logs){
			if( log.time<=time){
				if(map.containsKey(log.candidate)) map.put(log.candidate, map.get(log.candidate)+1);
				else map.put(log.candidate,1);
			}
		}
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(String str : map.keySet()) a.add(map.get(str));
		
		//find top K in a
		
		//method1: Using PriorityQuene.  time complexity: (nlgn+k)
		
		//method2: Using quick select
		
		quickSelect(a,0,a.size()-1,a.size()-k+1);
		System.out.println(a);
		
		for(int i=a.size()-k; i<a.size(); i++){
			int value = a.get(i);
			for(String str : map.keySet()){
				if(map.get(str)==value) result.add(str);
			}
		}
		
		
		return result;
	}
	
	public static void quickSelect(ArrayList<Integer> a, int start, int end,int k){
		int left = start, right = end;
		int pivot = a.get(end);
		
		while(left<right){
			while(left<right && a.get(left)<pivot){
				left++;
			}
			while(left<right && a.get(right)>=pivot){
				right--;
			}
			
			swap(a,left,right);
		}
		
		swap(a, end, left);
		
		if(k==left+1){
			return;
		}else if(k<left+1){
			quickSelect(a,start,left-1,k);
		}else{
			quickSelect(a,left+1,end,k);
		}
		
		
		
	}
	
	public static void swap(ArrayList<Integer> nums , int a, int b){
		int tmp = nums.get(a);
		nums.set(a,nums.get(b));
		nums.set(b, tmp);
	}
}


















