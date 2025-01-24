// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public int findMin(int[] nums) {
        //single element. return.
        if(nums.length == 1){
            return nums[0];
        }
        // Not rotated. 0th index is the minimum.
        if(nums[0] < nums[nums.length - 1]){
            return nums[0];
        }

        int l = 0, r = nums.length - 1;
        while(l <= r){
            int mid = l + (r-l)/2;
            // if mid is on the left portion, discard the left portion
            if(nums[mid] >= nums[0]){
                l = mid + 1;
            }
            // if mid is on the right portion, discard the right portion
            else if(nums[mid] < nums[0]){
                r = mid - 1;
            }
        }
        return nums[l];
    }
}