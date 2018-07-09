package test;

import java.util.Arrays;

public class WiggleSortII {
	
	
	
	public static int quickSort(int[] nums, int l, int r, int k) {
		int left = l, right = r;
		int pivot = nums[left];
		
		while (left <= right) {
			while (left <= right && nums[right] < pivot) {
				right--;
			}
			while (left <= right && nums[left] > pivot) {
				left++;
			}
			if (left <= right) {
				int tmp = nums[left];
				nums[left] = nums[right];
				nums[right] = tmp;
				left++;
				right--;
			}
		}
		
		if (l + k - 1 <= right) {
			return quickSort(nums,l,right,k);
		}
		if (l + k - 1 >= left) {
			return quickSort(nums,left,r,k - (left - l));
		}

		return right+1;
		
	}
	
	public static void wiggleSort(int[] nums) {
		
		int len = nums.length;
		int middle = len / 2 + len % 2;
		
		//you need to declare a new array to store the new array otherwise nums and wiggle_nums array share the same address
		//int[] wiggle_nums = Arrays.copyOf(nums, len);
		

		
		int left = 0, right = len - 1;
		
		int k = quickSort(nums, left, right, middle);
		int pivot = nums[k];
		
		int[] wiggle_nums = new int[len];
		for (int i=0; i<len; i++) {
			wiggle_nums[i] = pivot;
		}
		
		
		if (len%2 == 0) {
			int l = len-2;
			int r = 1;
			for (int i=0; i<len; i++) {
				if (nums[i] < pivot) {
					wiggle_nums[l] = nums[i];
					l = l - 2;
				}
				else if (nums[i] > pivot) {
					wiggle_nums[r] = nums[i];
					r = r + 2;
				}
			}
				
		} else if (len%2 == 1) {
			int l = 0;
			int r = len-2;
			for (int i=0; i<len; i++) {
				if (nums[i] < pivot) {
					wiggle_nums[l] = nums[i];
					l = l + 2;
				}
				else if (nums[i] > pivot) {
					wiggle_nums[r] = nums[i];
					r = r - 2;
				}
			}
		}
		
		for (int i=0; i<nums.length; i++) {
			nums[i] = wiggle_nums[i];
		}


	}
	
	public static void main(String[] args) {
		//int[] nums = {1,2,1,2,1,1,2,2};
		//int[] nums = {1,2,1,2,1,1,2,2,1};
		int[] nums = {3,5,2,1,6,4,7,8};
		//int[] nums = {4,5,5,6};
		//int[] nums = {1};
		//int[] nums = {};
		wiggleSort(nums);
		
	}
	
}
