//Time Complexity : O(logn)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : Found difficulty in finding a the best solution at first attempt.


class First_and_Last_Position_Element_in_Sorted_Array {
	
	private int leftBinarySearch(int[] nums, int target)
	{
		int leftIndex = -1;
		int first = 0;
        int last = nums.length - 1;
		
		while(first <= last)
		{
			int mid = first + (last - first) / 2;
			
			if((mid == first ||nums[mid] > nums[mid - 1]) && nums[mid] == target)
				return mid;
			else if (nums[mid] >= target)
				last = mid - 1;
			else
				first = mid + 1;
		}
		return leftIndex;
	}
	
	private int rightBinarySearch(int[] nums, int target)
	{
		int rightIndex = -1;
		int first = 0;
        int last = nums.length - 1;
		
		while(first <= last)
		{
			int mid = first + (last - first) / 2;
			
			if((mid == last || nums[mid] < nums[mid + 1]) && nums[mid] == target)
				return mid;
			else if (nums[mid] > target)
				last = mid - 1;
			else
				first = mid + 1;
		}
		return rightIndex;
	}
	public int[] searchRange(int[] nums, int target) {
		
		if(nums == null || nums.length == 0)
			return new int[] {-1, -1};

		int leftIndex = leftBinarySearch(nums, target);
		int rightIndex = rightBinarySearch(nums, target);

		return new int[] {leftIndex, rightIndex};
    }
	
	public static void main(String[] args) { 
		int[] nums = {0,1,2,3,4,5,6,8,8,8,9,10};
		int[] nums2 = {8,8,8,8,8,8,8,8};
		
		First_and_Last_Position_Element_in_Sorted_Array srch = new First_and_Last_Position_Element_in_Sorted_Array();
		
		srch.searchRange(nums, 8);
		
		srch.searchRange(nums2, 8);
	
	}

}
