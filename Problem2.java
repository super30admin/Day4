//Time Complexity: O(logn)
//Space Complexity: constant
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// we can make use of binary search to search for the target as the elements are in sorted order in the matix


class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        int lo = 0;
        int hi = nums.length - 1;
        if(nums[lo] <= nums[hi])
            return nums[lo];
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(nums[lo] <= nums[hi])
                return nums[lo];
            if((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1]))
                return nums[mid];
            else if(nums[lo] <= nums[mid])
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }
}
