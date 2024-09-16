// Time Complexity : O(log N) 
// Space Complexity : O(1)  because iterative binary search
// Did this code successfully run on Leetcode : YYes
// Any problem you faced while coding this : No

class PeakElement {
    public int findPeakElement(int[] nums) {
        int low = 0; int high = nums.length - 1;
        while(low < high) {
            int mid = low + (high-low)/2;
            if(nums[mid] > nums[mid+1]) high = mid;
            else low = mid+1;
        }
        return low;
    }
}