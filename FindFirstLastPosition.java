/*
Passed all test cases
TC - O(logn)
SC - O(1)
Method - Using two binary search methods, one is to find first and other is to find last occurrence. When finding first occurence, we first find mid element match of the target element, and continue to find first occurence by comparing the mid with the before element. 
When finding last occurrence, check if the mid matches target, then element next to mid matches the target. If so, update the low and continue. Else thats the last occurrence and return it.

*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length == 0)
            return new int[]{-1,-1};
        int left = binarySearchLeft(nums,target); // to find the first occurence. dont stop if you find a match with the target element, continue and find first occurrence
        if(left==-1) //if this is true, it means we didnt find any occurence. no point in checking the last occurrence, so return -1
            return new int[]{-1,-1};
        int right = binarySearchRight(nums,target, left);
        //passing the left index rather than checking it from 0 (low) for last occurrence
        return new int[]{left,right};
    }
    private int binarySearchLeft(int[] nums, int target)
    {
        int low = 0;
        int high = nums.length-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid]==target) // if the element is equal to target, check if the before element is equal to target or not. If so, update high and continue BS to find first occurence. Else, thats the first occurence and return it
            {
                if(mid==low || nums[mid-1]!=target)
                {
                    return mid;
                }
                else
                {
                    high = mid -1;
                }
                
            }
            else if(nums[mid] > target)
            {
                high = mid -1;
            }
            else
            {
                low = mid +1;
            }
        }
        return -1;
    }        
    private int binarySearchRight(int[] nums, int target, int low)
    {  
        int high = nums.length-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid]==target)
            {
                if(mid==high || nums[mid+1]!=target)
                    return mid;
                else
                    low = mid +1;   
            }
            else if(nums[mid] > target)
            {
                high = mid -1;
            }
            else
            {
                low = mid +1;
            }
        }
        return -1;       
    }          
    
}