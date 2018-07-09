package test;

import java.util.Arrays;

public class WiggleSort {
	
	public static int[] quickSort(int[] nums, int l, int r, int k) {
		int left = l, right = r;
		int pivot = nums[left];
		
		while (left <= right) {
			while (left <= right && nums[right] > pivot) {
				right--;
			}
			while (left <= right && nums[left] < pivot) {
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
		return nums;
		
	}
	
	public static void wiggleSort(int[] nums) {
		
		int len = nums.length;
		int middle = len / 2 + len % 2;
		//System.out.println(middle);
		int leftside[] = new int[len / 2 + len % 2];
		int rightside[] = new int[len / 2];
		
		//you need to declare a new array to store the new array otherwise nums and wiggle_nums array share the same address
		//int[] wiggle_nums = Arrays.copyOf(nums, len);
		
		int[] wiggle_nums = new int[len];
		for (int i=0; i<len; i++) {
			wiggle_nums[i] = nums[i];
		}
		
		int left = 0, right = len - 1;
		
		if (len > 0) {wiggle_nums = quickSort(wiggle_nums, left, right, middle);}
		System.out.println(Arrays.toString(wiggle_nums));
		for (int i=0; i < middle; i++) {
			nums[2*i] = wiggle_nums[i];
			if (i+middle < len) {nums[2*i+1] = wiggle_nums[i+middle];}
		}
		System.out.println(Arrays.toString(wiggle_nums));
		System.out.println(Arrays.toString(nums));
	}
	
	
//	public static void swap (int[] nums, int i, int j) {
//		
//		int temp = nums[i];
//		nums[i] = nums[j];
//		nums[j] = temp;
//
//	}
//	
//	public static void wiggleSort(int[] nums) {
//		
//		for (int i=0; i<nums.length-1; i++) {
//			if ((i%2 == 0 && nums[i] >= nums[i+1]) | (i%2 == 1 && nums[i] <= nums[i+1])) {
//				swap(nums,i,i+1);
//			}
//		}
//		
//		System.out.println(Arrays.toString(nums));
//		
//	}
	
	
	public static void main(String[] args) {
		//int[] nums = {3,5,2,1,6,4,7};
		int[] nums = {4,5,5,6};
		//int[] nums = {};
		wiggleSort(nums);
		
	}
}
