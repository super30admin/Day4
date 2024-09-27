
public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {
	//Approach:1. Here am finding the target first, once found, will return if the position is first occurrence of the target 
	//or will again move the right pointer to mid-1 and search for first occurrence of target.
	//2. By same approach as above will try to find last occurrence of target position. 
	public int[] searchRange(int[] nums, int target) {
        int starting = startingPointBinarySearch(nums,target,0,nums.length-1);
        int ending = endingPointBinarySearch(nums,target,0,nums.length-1);
        return new int[]{starting,ending};
    }
    public int startingPointBinarySearch(int[] nums, int target, int left, int right)
    {
        while(left <= right)
        {
            int mid = left + (right-left)/2;
            if(nums[mid] == target)
            {
                if(mid == 0 || nums[mid-1] < target)
                    return mid;
                else
                    right = mid -1;
            }else if(nums[mid] < target)
                left = mid +1;
            else
                right = mid-1;
        }
        return -1;
    }
    public int endingPointBinarySearch(int[] nums, int target, int left, int right)
    {
         while(left <= right)
        {
            int mid = left + (right-left)/2;
            if(nums[mid] == target)
            {
                if(mid == nums.length-1 || nums[mid+1] > target)
                    return mid;
                else
                    left = mid +1;
            }else if(nums[mid] < target)
                left = mid +1;
            else
                right = mid-1;
        }
        return -1;
    }
}


//Time Complexity : O(log n), for finding first and second positions.
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :
