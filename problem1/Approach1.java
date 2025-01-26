package problem1;

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

import java.util.Arrays;

public class Approach1 {

    public static void main(String[] args) {
        Approach1 obj = new Approach1();

//        int[] nums = new int[] {5,7,7,8,8,10};
        int[] nums = new int[] {};

//        int target = 8;
//        int target = 6;
        int target = 0;

        System.out.println(Arrays.toString(obj.searchRange(nums, target)));
    }

    private int binarySearchFirst(int[] nums, int low, int high, int target) {

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // check with mid - 1
            if(nums[mid] == target) {

                if(mid == 0 || nums[mid] != nums[mid - 1]) {
                    return mid;
                }
                // if not the 1st index keep moving left
                else {
                    high = mid - 1;
                }
            }
            // shift to left half
            else if(nums[mid] > target) {
                high = mid - 1;
            }
            // shift to right half
            else {
                low = mid + 1;
            }
        }

        return -1;
    }

    private int binarySearchLast(int[] nums, int low, int high, int target) {

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // check with mid - 1
            if(nums[mid] == target) {

                if(mid == nums.length - 1 || nums[mid] != nums[mid + 1]) {
                    return mid;
                }
                // if not the 1st index keep moving right
                else {
                    low = mid + 1;
                }
            }
            // shift to left half
            else if(nums[mid] > target) {
                high = mid - 1;
            }
            // shift to right half
            else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public int[] searchRange(int[] nums, int target) {

        int n = nums.length;
        if (nums == null || n == 0) {
            return new int[] {-1, -1};
        }

        if (target < nums[0] || target > nums[n - 1]) {
            return new int[] {-1, -1};
        }

        int first = binarySearchFirst(nums, 0 , n-1, target);

        //  if the first index is not found then return -1, -1
        if (first  == -1 ) {
            return new int[] {-1, -1};
        }

        int last = binarySearchLast(nums, first , n-1, target);

        return new int[] {first, last};
    }
}
