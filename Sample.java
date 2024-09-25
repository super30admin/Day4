
class Solution {

    // Time Complexity : O(log n)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No


    // Question : Find Minimum in Rotated Sorted Array
    /*
    1. Find the rotate index.
    */

    public int findMin(int[] nums) {

        if(nums == null || nums.length == 0)
            return -1;
        
        if(nums.length == 1)
            return nums[0];
        
        int left = 0, right = nums.length-1;

        if(nums[left] < nums[right])
            return nums[0];
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            
            if(nums[mid] > nums[mid+1])
                return nums[mid+1];
            
            if(nums[mid] < nums[left])
                right = mid - 1;
            else
                left = mid + 1;
        }
        
        return nums[0];
    }

    // Time Complexity : O(log n)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No


    // Question : Find First and Last Position of Element in Sorted Array
    /*
    1. Find the starting index by taking the mid and choosing the part of the array to iterate by comapring the mid 
    with the target (whether mid value is greater than or eqaul to target).
    2. Find the ending index by the same method as above except the mid value is only checked if it is greater than
    target value
    */

    public int[] searchRange(int[] nums, int target) {
       
        int[] res = {-1, -1};
        
        if(nums == null || nums.length == 0)
            return res;
        
        int leftIndex = getPositions(nums, target, true);
        
        if(leftIndex == nums.length || nums[leftIndex] != target)
            return res;
        
        res[0] = leftIndex;
        
        int rightIndex = getPositions(nums, target, false);
        
        res[1] = rightIndex-1;
        
        return res;
        
         
    }
    
    int getPositions(int[] nums, int target, boolean leftOrRight) {
        int left = 0, right = nums.length; 
        
        while(left < right) {
            int mid = left + (right-left)/2;
            
            if(nums[mid] > target || ( leftOrRight && nums[mid] == target))
                right = mid;
            else
                left = mid + 1;
        }
        
        return left;
    }

    // Time Complexity : O(log n)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : Need more clarification on algorithm


    // Question : Find Peak Element
    /*
    */

    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length-1;
        
        while(low < high) {
            int mid = low + (high - low)/2;
            
            if(nums[mid] > nums[mid+1])
                high = mid;
            else
                low = mid+1;
        }
        
        return low;
    }
}