class Solution {
    
    // Time Complexity : O(log n) where n is the size of the input array
    // Space Complexity : O(1) 
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : Trying with single search but too many edge cases
    public int[] searchRange(int[] nums, int target) {
        if ( nums == null || nums.length == 0 )
            return new int[] {-1,-1};
        int first = binarySearch(nums,target,0);
        int last = binarySearch(nums,target,1);
        return new int[]{first,last};
    }
    
    private int binarySearch(int[] nums,int target, int position) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            //check if target is first or last based on condition and move to other direction
            if(nums[mid] == target) {
                if (position == 0) {
                if(mid == 0 || nums[mid] > nums[mid -1])
                    return mid;
                else
                    r = mid - 1;
                }
                else {
                    if(mid == nums.length - 1 || nums[mid + 1] > nums[mid])
                    return mid;
                else
                    l = mid + 1;
                }
                
            }
            //we have to move left to find the target else move right
            else if (nums[mid] > target)
                r = mid -1;
            else
                l = mid + 1;
        }
        return -1;
    }
}
