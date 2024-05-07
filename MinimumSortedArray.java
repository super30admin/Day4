// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// Any problem you faced while coding this : No


class Solution {
    public int findMin(int[] nums) {
        // Initialize left and right for start and end of an array
        int left = 0, right = nums.length-1;
        //Initialize a variable which will contain the minimum element
        int result = nums[0];
        // Check the while conditon for binary search
        while(left<=right){
            //check for sorted array condition
            if(nums[left]<nums[right]){
                result = Math.min(result,nums[left]);
                return result;
            }// Check for condition if the array is rotated
             // find the mid point of
             //an array
            int mid = left+(right-left)/2;
            result = Math.min(result,nums[mid]);
                if(nums[mid]>nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
        }
        return result;
    }
}
