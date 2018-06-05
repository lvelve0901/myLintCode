package test;

import java.util.Arrays;

public class MinimumWindowSubstring {
	
	public static int[] init_target(String target) {
		int[] target_hash = new int[256];
		
		for (int i=0; i < target.length(); i++) {
			target_hash[target.charAt(i)] += 1;
		}
		
		return target_hash;
	}
	
	public static boolean valid(int[] source_hash, int[] target_hash) {
		
		boolean isValid = false;
		
		for (int i=0; i<target_hash.length; i++) {
			if ((target_hash[i] > 0) & (source_hash[i] < target_hash[i])) {
				return isValid;
			}
		}
		
		isValid = true;
		
		return isValid;
	}
	
	public static String minWindow(String source, String target) {
        // write your code here
		
		int[] source_hash = new int[256];
		int[] target_hash = init_target(target);
		int i = 0, j = 1;
		int minlen = Integer.MAX_VALUE;
		String ans = "";
		
		if (source.length() < 1) {
			return ans;
		}
		
		source_hash[source.charAt(0)] += 1; // initialize the first element to hashtable
		for (i=0; i<source.length(); i++) {
			
			/*
			 * template of non-traceback double pointer O(n)
			 */
			while(j < source.length()) {
				if (!valid(source_hash,target_hash)) {
					source_hash[source.charAt(j)] += 1;
					j = j + 1;
				}
				else {
					break;
				}
			}
			
			if (valid(source_hash,target_hash)) { // must check if valid since we are truncating the front during the loop and we have to make sure to update the valid one
				if (minlen > j - i) {
					minlen = j - i;
					ans = source.substring(i, j);
				}
			}
			
			source_hash[source.charAt(i)] -= 1; // truncate the front during the loop
			
		}
		
		return ans;
    }
	
	public static void main (String[] args) {
		String source = "ADOBECODEBANC";
		String target = "ABC";
		System.out.println(minWindow(source, target));

	}
	
}
