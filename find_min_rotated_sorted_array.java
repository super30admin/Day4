// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes


class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        
        int left_pointer = 0;
        int right_pointer = nums.length-1;
        
        // if array is not rotated, first element is smallest
        if(nums[right_pointer] > nums[left_pointer])
            return nums[0];
        
        while(right_pointer>=left_pointer){
            int mid = left_pointer + (right_pointer-left_pointer)/2;
            
            // find the location of smallest element(when there is change in order)
            if(nums[mid] > nums[mid+1])
                return nums[mid+1];
            if(nums[mid-1] > nums[mid])
                return nums[mid];
            
            // if mid element is greater than mid search in right part else check in left
            if(nums[mid] > nums[0])
                left_pointer = mid+1;
            else
                right_pointer = mid+1;
        }
        return -1;
    }
}