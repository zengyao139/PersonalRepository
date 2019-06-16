package com.zengyao.test;

import java.util.Scanner;

public class Test {
	    
	    public static void main(String[] args){
	        
	        Scanner s = new Scanner(System.in);
	        while(s.hasNextInt()){
	            int n = s.nextInt(); //学生人数
	            int[] ability = new int[n];
	            for(int i = 0; i < n; i++){
	                ability[i] = s.nextInt();
	            }
	            int k = s.nextInt();
	            int d = s.nextInt();
	            
	            //maxProduct[i][j]表示以第i个人为结尾，合唱团的人数为j+1时，合唱团最大的能力乘积
	            long[][] maxProduct = new long[n][k]; 
	            //minProduct[i][j]表示以第i个人为结尾，合唱团的人数为j+1时，合唱团最小的能力乘积
	            long[][] minProduct = new long[n][k];
	            
	            //合唱团中只有一个人
	            for(int i = 0; i < n; i++){
	                maxProduct[i][0] = ability[i];
	                minProduct[i][0] = ability[i];
	            }
	            
	            long max = Long.MIN_VALUE;
	            for(int i = 0; i < n; i++){
	                for(int j = 1; j < k; j++){
	                    for(int p = i-1; p >= Math.max(i-d,0); p--){
	                        maxProduct[i][j] = Math.max(maxProduct[i][j],
	                                           maxProduct[p][j-1]*ability[i]);
	                        maxProduct[i][j] = Math.max(maxProduct[i][j],
	                                   minProduct[p][j-1]*ability[i]);
	                        minProduct[i][j] = Math.min(minProduct[i][j],
	                                   minProduct[p][j-1]*ability[i]);
	                        minProduct[i][j] = Math.min(minProduct[i][j],
	                                   maxProduct[p][j-1]*ability[i]);
	                    }
	                }
	              max = Math.max(max, maxProduct[i][k-1]);
	            }
	            
	            System.out.println(max);
	            
	        }
	        
	    }


}
