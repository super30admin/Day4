// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach : Check for boundary conditions if the peak element is at first or last index and check if the mid element is higher than previous or next element if yes that is the peak element,
// if not then if mid is less than next element move low to mid + 1 elese high to mid -1
class PeakElement {
    public int findPeakElement(int[] nums) {
        // Check if array is not empty
        if(nums==null || nums.length==0) return -1;
        int low=0, high=nums.length-1;
        while(low<=high) {
            int mid = low + (high - low)/2;
            // To check edge case of peak being first and last index and mid element being greater than its adjacent elements
            if((mid==nums.length-1 || nums[mid]>nums[mid+1]) && (mid==0 || nums[mid]>nums[mid-1])) {
             return mid;    
            } else if(nums[mid]<nums[mid+1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
