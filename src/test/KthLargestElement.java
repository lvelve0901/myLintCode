package test;

import java.util.Arrays;

//public class KthLargestElement {
//	
//	private static int quickSelect(int[] nums, int l, int r, int k) {
//		
//		// initialize left and right pointer and pivot point
//		int left = l, right = r;
//		int pivot = nums[left];
//		
//		// do the partition
//		while ( left <= right ) {
//			while ( left <= right && nums[right] < pivot) {
//				right--;
//			}
//			while ( left <= right && nums[left] > pivot) {
//				left++;
//			}
//			if ( left <= right) {
//				int tmp = nums[left];
//				nums[left] = nums[right];
//				nums[right] = tmp;
//				left++;
//				right--;
//			}
//		}
//		
//		System.out.println(left);
//		System.out.println(right);
//		System.out.println(Arrays.toString(nums));
//		
//		
//		if (l + (k - 1) <= right) {
//			System.out.println("fuck1");
//			return quickSelect(nums,l,right,k);
//		}
//		if (l + (k - 1) >= left) {
//			System.out.println("fuck2");
//			return quickSelect(nums,left,r,k - (left - l));
//		}
//		
//		return nums[right+1];
//	}
//	
//    public static int kthLargestElement(int k, int[] nums) {
//    	
//    	int left = 0, right = nums.length - 1;
//    	return quickSelect(nums,left,right,k);
//
//    }
//    
//    public static void main(String[] args) {
//    	int k = 4;
//    	//int k = 3;
//    	int[] nums = {6,3,7,11,9,3,2,4,12,8,5};
//    	//int[] nums = {9,3,2,4,8};
//    	System.out.println(kthLargestElement(k,nums));
//    }
//    
//}

public class KthLargestElement {
	
	private static int quickSelect(int[] nums, int l, int r, int k) {
		int left = l, right = r;
		int pivot = nums[left];
		
		// do the partition
		while(left <= right) {
			while(left <= right && nums[right] < pivot) {
				right--;
			}
			while(left <= right && nums[left] > pivot) {
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
			return quickSelect(nums,l,right,k);
		}
		if (l + k - 1 >= left) {
			return quickSelect(nums,left,r,k-(left - l));
		}
		return nums[right+1];

	}
	
    public static int kthLargestElement(int k, int[] nums) {
    	int left = 0, right = nums.length - 1;
    	return quickSelect(nums, left, right, k);

    }
    
    public static void main(String[] args) {
    	int k = 4;
    	//int k = 3;
    	int[] nums = {6,3,7,11,9,3,2,4,12,13,10,8,5};
    	//int[] nums = {9,3,2,4,8};
    	System.out.println(kthLargestElement(k,nums));
    }
    
}