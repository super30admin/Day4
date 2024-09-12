// Time Complexity : O(logn) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

public class Problem2 {

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {

            if (nums[low] <= nums[high])
                return nums[low]; // the array is already sorted and the first element is the minimum
            int mid = low + (high - low) / 2;
            if ((mid == nums.length - 1 || nums[mid] < nums[mid + 1]) && (nums[mid] < nums[mid - 1] || mid == 0))
                return nums[mid];
            else if (nums[low] > nums[mid]) { // left side of mid is unsorted, so go left and do BS
                high = mid - 1;
            } else if (nums[mid] > nums[high]) {// right side of mid is unsorted, so go right and do BS
                low = mid + 1;
            }
        }
        return -1;
    }

}
