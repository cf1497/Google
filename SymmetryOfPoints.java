package algorithm;

import java.util.HashSet;

public class SymmetryOfPoints {

	public static void main(String[] args){
		double[] nums= {0,1,3,6,8,9};
		System.out.println(isSymmetry(nums));
	}
	
	public static boolean isSymmetry(double[] nums){
		double sum = 0;
		for(double k:nums) sum+=k;
		double mid = sum/nums.length;
		System.out.println(mid);
		
		HashSet<Double> set = new HashSet<Double>();
		for(double k: nums){
			set.add(k);
		}
		
		for(double k: nums){
			if(!set.contains(2*mid-k)) return false;
			else{
				set.remove(2*mid-k);
			}
		}
		
		return true;
	}
	
	
}