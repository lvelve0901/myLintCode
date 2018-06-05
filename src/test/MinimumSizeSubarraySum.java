package test;

import java.util.Arrays;

public class MinimumSizeSubarraySum {
	
	public static int minimumSize(int[] nums, int s) {
		
		int len = -1;
		int ans = Integer.MAX_VALUE;
		int cur = 0;
		
		cur = cur + nums[0];
		for (int i = 0, j = 1; i < nums.length; i++) {
			
			while ((cur < s) & (j < nums.length)) {
				
				cur = cur + nums[j++];
				
			}
			System.out.println("break");
			System.out.println(Arrays.toString(Arrays.copyOfRange(nums, i, j)));
			
			if (cur >= s) {
				ans = Math.min(ans, j-i);
			}
			cur = cur - nums[i];
			
		}
		
		if (ans == Integer.MAX_VALUE) {
			ans = -1;
		}
		
		return ans;
	}
	
	public static void main(String[] args){
		
		int[] nums = {2,3,1,2,4,3};
		int s = 7;
		int ans = minimumSize(nums,s);
		System.out.println(ans);
		
	}
	
}
