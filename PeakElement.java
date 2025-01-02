// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in three sentences only:
/*Perform Binary serach, If the middle element is smaller than the next element, then the peak is in the right half
  If the middle element is greater than or equal to the next element, the peak is in the left half
When left == right, we've found the peak element*/
class PeakElement{
    public int findPeakElement(int[] nums) {

    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
        int mid = left + (right - left) / 2;

        if (nums[mid] < nums[mid + 1]) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }

    return nums[left];  
}
}