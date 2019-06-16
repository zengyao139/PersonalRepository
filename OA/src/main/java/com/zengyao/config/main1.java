package com.zengyao.config;

import java.util.HashMap;
import java.util.Map;

public class main1 {
	public static void main(String[] args) {
		int[] mub={2,7,11,14};
		int  m[]=twoSum(mub,9);
		System.out.println(m[0]+","+m[1]);
	}
	
	public static int[] twoSum(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement)) {
	            return new int[] { map.get(complement), i };
	        }
	        map.put(nums[i], i);
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
	
	
}
