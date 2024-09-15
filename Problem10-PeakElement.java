// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : It was difficult for me to come up with conditions without hitting array out of bounds exception.
//https://leetcode.com/problems/find-peak-element/


// Your code here along with comments explaining your approach

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1; //handling edge case
        int l = 0, h = nums.length - 1;
        while(l<=h) { 
            int mid = l + (h-l)/2; // to avoid overflow
            if((mid == nums.length-1 || nums[mid] > nums[mid+1]) 
               && (mid == 0 || nums[mid-1] < nums[mid])) 
                return mid; //element found
            else if(nums[mid] < nums[mid+1]){ //left is higher than mid
                l = mid + 1;
            } else { //right is higher than mid
                h = mid - 1;
            }
        }
        return nums.length-1;
    }
}