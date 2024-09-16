// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findPeakElement(int[] nums) {
        int left =0,right = nums.length-1;
        while(left<=right){
            int mid = left+(right - left)/2;
            
            // Binary Search to find the peak elemnet greater than the neighboring two elements
            // @return if mid element is peak
            if((mid ==0|| nums[mid] > nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1]))
                return mid;
            // traverse towards left end to find the peak
            else if(nums[mid] > nums[mid+1]) right = mid-1;
            // traverse towards right end to find the peak
            else left = mid+1;
        }
        return -1;
    }
}
