// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class peakElement {
    public int findPeakElement(int[] nums) {
        // check if the array is null or empty
        if(nums == null || nums.length == 0) return -1;
        // intialize low and high pointers
        int low = 0;
        int high = nums.length - 1;
        // binary search
        while(low <= high){
            // intialize mid
            int mid = low + (high - low) / 2;
            // if element at mid is the peak element
            // also check for boundary conditons
            if((mid == 0 || nums[mid] > nums[mid - 1])
                    && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])){
                return mid;
            } else if(mid != 0 && nums[mid -1] > nums[mid]){
                // if mid is not the first element of the array and is lesser than previous element
                // search the left part of the array
                high = mid - 1;
            } else {
                // element next to mid is greater than element at mid
                // search for right part of the array
                low = mid + 1;
            }
        }
        return -1;
    }
}