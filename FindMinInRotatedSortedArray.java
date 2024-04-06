// Time Complexity : O(log(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
properties of a sorted array
1.  nums[left] < nums[right]
In a rotated sorted array the min would be the number that satisfies the below;
nums[mid-1]> nums[mid] < nums[mid+1]

In order to find the min, in a truely roatated aray:
if we split the array into half, the min would always be in the unsorted array.
Why? because, if the unsorted side still holds the min value.

Keep in mind the boundary conditions
what if mid ==0 ? or what if mid == nums.length-1 ?
 * 
 */

public class FindMinInRotatedSortedArray {

    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] <= nums[right])
                return nums[left];
            int min = left + (right - left) / 2; // Avoid integer overflow
            if ((min == 0 || nums[min - 1] > nums[min]) && (min == nums.length - 1 || nums[min + 1] > nums[min])) {
                return nums[min];
            }

            if (nums[left] <= nums[min]) { // why this <= ? not < alone?
                left = min + 1;
            } else {
                right = min - 1;
            }

        }

        return -1;

    }

}
