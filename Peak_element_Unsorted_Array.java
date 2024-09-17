class Solution {
    // Time complexity is O(logn)
    // Space complexity is O(n)
    // This solution is submitted on leetcode with no errors
    public int findPeakElement(int[] nums) {
        //edge case
        if(nums == null || nums.length == 0) return -1;
        int low = 0;
        int high = nums.length -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            // checking the peak element
            if((mid ==0 || nums[mid]> nums[mid-1]) &&
               (mid == nums.length-1 || nums[mid]>nums[mid+1])) return mid;
            else if(nums[mid]<nums[mid+1]){
                // checking where is the greater element and moving there
                low = mid+1;
            } else {
                high = mid -1;
            }
        }    
        return -1;
    }
}