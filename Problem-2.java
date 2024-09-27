class Solution {
    
    // Time Complexity : O(log n) where n is the size of the input array
    // Space Complexity : O(1) 
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : Nope
    
    public int findMin(int[] nums) {
        
        int l = 0;
        int r = nums.length - 1;
        while ( l < r) {
            int mid = l + (r - l) /2;
            //cheeck if right subarray is sorted.If yes, move to left else move to right
            if(nums[mid] < nums[r])
                r = mid;
            else 
                l = mid + 1;
        }
        return nums[l];
    }
}
