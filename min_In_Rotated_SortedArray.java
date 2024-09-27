//Time Complexity : O(logn)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : Found difficulty in finding a the best solution at first attempt.

class min_In_Rotated_SortedArray {
	
	public int findMin(int[] nums) {

		int leftIndex = 0;
		int rightIndex = nums.length-1;
		
		if(nums == null || nums.length == 0)
			return Integer.MAX_VALUE;

		while(rightIndex - leftIndex > 1)
		{
			int midValue = leftIndex + (rightIndex - leftIndex) / 2;
			
			if(nums[rightIndex] < nums[midValue])
				leftIndex = midValue + 1;
			else if(nums[leftIndex] < nums[midValue])
				rightIndex = midValue - 1;
			else
				rightIndex = midValue;
        }
        if(nums[leftIndex] < nums[rightIndex])
			return nums[leftIndex];
		else
			return nums[rightIndex];
			
		
	}
	
	public static void main(String[] args) { 
		int[] nums = {4,5,6,7,-1,0,1,2,3};
		int[] nums2 = {3,4,5,1,2};
		
		min_In_Rotated_SortedArray srch = new min_In_Rotated_SortedArray();
		
		System.out.println(srch.findMin(nums));
		
		System.out.println(srch.findMin(nums2));

		
	}
}