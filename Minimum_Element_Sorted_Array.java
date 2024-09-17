class Solution {
    // Time complexity is O(logn)
    // Space complexity is O(n)
    // This solution is submitted on leetcode with no errors
    
    public int findMin(int[] nums) {
        // edge case
        if (nums == null || nums.length == 0) return -1;
        int low = 0;
        int high = nums.length -1;
        while(low<=high){
            if (nums[low]<=nums[high]) return nums[low];
            int mid = low + (high - low)/2;
            // checking if mid is lower element or not
            if ((mid == 0 || nums[mid]<nums[mid-1]) && 
                (mid == nums.length-1 || nums[mid]< nums[mid+1])) {
                return nums[mid];
            } else if (nums[low]<= nums[mid]) {
                // left side is sorted move to right side
                low = mid +1;
            } else {
                // right side is sorted, move to left
                high = mid -1;
            }
        }
        return -1;
    }
}