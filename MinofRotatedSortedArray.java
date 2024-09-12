//Problem
153. Find Minimum in Rotated Sorted Array
        Suppose an array of length n sorted in ascending order is rotated between 1and n times.For example,the array nums=[0,1,2,4,5,6,7]might become:
        [4,5,6,7,0,1,2]if it was rotated 4times.
        [0,1,2,4,5,6,7]if it was rotated 7times.
        Notice that rotating an array[a[0],a[1],a[2],...,a[n-1]]1time results in the array[a[n-1],a[0],a[1],a[2],...,a[n-2]].

        Given the sorted rotated array nums of unique elements,return the minimum element of this array.

        You must write an algorithm that runs in O(log n)time.


// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
compare mid value with high element and if mid value is greater than high's value then do binary search on right subarray or else to its left
 */
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int start = 0;
        int end = nums.length - 1;


        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[start] < nums[end]) return nums[start];
            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            } else if (nums[start] <= nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;

    }
}