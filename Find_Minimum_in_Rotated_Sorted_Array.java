
public class Find_Minimum_in_Rotated_Sorted_Array {
	
	//Approach: 1. The minimum element will be the pivot and in this case, it cannot be in the sorted array
	//2. Here the pivot can be identified, by comparing with neighbors. 
	//3. So we divide array using binary search and go to the unsorted array to find the pivot element. 
	public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        if(nums[left] <= nums[right])
            return nums[left];
        while(left <= right)
        {
            int mid = left + (right-left)/2;
            if(nums[mid] > nums[mid+1])
                return nums[mid+1];
            else
            {
                if(nums[mid] < nums[left] )
                    right = mid-1;
                else
                    left = mid+1;
            }
        }
        return nums[left];
    }
}

//Time Complexity : O(log n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :