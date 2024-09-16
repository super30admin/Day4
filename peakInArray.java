//time complexity: O(log n)
//space complexity:O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int findPeakElement(int[] nums) {
        return searchPeak(nums, 0, nums.length-1);
    }
    
    private int searchPeak(int[] nums, int l, int r) {
        
        while(l<=r) {
            int mid = l + (r-l)/2;
    
            //if mid is 0, then only 1 item in array
            //prev item is less than mid  &&
            // mid == n ---> trailed by infinity, hence mid is peak
            // or next item is less than mid --> mid is peak
            if((mid == 0 ||
             nums[mid-1] < nums[mid]) && (mid == nums.length -1 || nums[mid+1] < nums[mid])) {
                return mid;
            }
            
            // mid is less than prev item 
            //or mid is 0 --> 2 items in array 
            //reduce search space to mid+1, r
            if(mid == 0 || nums[mid] > nums[mid-1]) {
                l = mid+1;
            } else {
                //reduce search space to l, mid-1
                r = mid-1;
            }
        }
        
        return -1;
        
    }
}