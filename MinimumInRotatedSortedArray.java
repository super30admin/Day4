// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in three sentences only:
/*Perform Binary serach,// If the middle element is greater than the rightmost element,it means the minimum is in the right half
 *  Otherwise, the minimum is in the left half. When left == right, we have found the minimum element
*/


class MinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
       int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    
}
}