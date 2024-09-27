class Solution {
    
    // Time Complexity : O(log n) where n is the size of the input array
    // Space Complexity : O(1) 
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : Nope
    
    
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int l = 0;
        int r = nums.length -1;
        while(l < r) {
            int mid = l + (r - l) / 2;
            //check if mid element is peak or not
            if(nums[mid] > nums[mid + 1] && (mid == 0 || nums[mid] > nums[mid -1]))
               return mid;
            // check if left is sorted or right is sorted and move accordingly
             else if (nums[mid] > nums[mid + 1])
                r = mid - 1;
            else
                l = mid + 1;
        }       
        return l;
    }
}
