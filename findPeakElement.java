// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while(low<=high) {
            mid = low+(high-low)/2;
            //checking if mid at the current iteration is higher or lower than the range - 1,
            //so that we can check the previous and next elements to mid, if mid forms a peak or not
            if(mid > low && mid < high && nums[mid] > nums[mid-1] &&  nums[mid] > nums[mid+1]) {
                break;
            }
            //if element in mid is equal to greater than its next, we are updating the low to mid + 1,
            // so for instance, cases like this 1,2,2,1
            if(mid < high && nums[mid] <= nums[mid+1]) low = mid + 1;
            else high = mid - 1;
        }
        return mid;
    }
}