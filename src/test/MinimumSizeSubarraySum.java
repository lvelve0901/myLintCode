package test;

public class MinimumSizeSubarraySum {
	
	public static int minimumSize(int[] nums, int s) {
		
		// O(n) because j doesn't need to traceback to i+1 everytime
		
		int ans = Integer.MAX_VALUE;  
		int cur = 0; // record current sum
		
		cur = cur + nums[0]; // initialize the current sum
		for (int i = 0, j = 1; i < nums.length; i++) { // back pointer start at zero, front pointer start at one
			
			
			while ((cur < s) & (j < nums.length)) {
				
				cur = cur + nums[j++]; // first cur += nums[j] then j = j + 1
				
			}
			
			if (cur >= s) {
				ans = Math.min(ans, j-i);
			}
			cur = cur - nums[i]; // remove the first one when move to the next loop
			
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
