// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class findPeakElement {

    public int findPeakElement(int[] nums) {
        
        if(nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length-1;
        
        while(low <= high) {
            
            int mid = low + (high - low) / 2;
            
            //check if the middle element is the peak element
            if((mid == low || nums[mid] > nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1])) return mid; 
            else if((mid != nums.length-1) && nums[mid] < nums[mid+1]) //keep checking the side, which has greater value than the mid value.
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}