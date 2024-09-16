class Solution {

    /*
     * Time Complexity - O(logn)
     * Space Complexity - O(1)
     */
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        int low = 0, high = nums.length-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if ((mid == 0 || nums[mid] > nums[mid-1]) 
                && (mid == nums.length-1 || nums[mid] > nums[mid+1]))
                return mid;
            else if (mid > 0 && nums[mid] < nums[mid-1])
                high = mid-1;
            else 
                low = mid + 1;
        }
        return -1;
    }
}