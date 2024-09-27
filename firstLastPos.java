// Time Complexity : O(logn) + O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.Arrays;

class Main {

    public static int binarySearch(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;
        // traverse for finding the target element
        while (l <= r) {
            // find the mid element
            int mid = l + (r - l) / 2;
            // if mid elemen is equal to our target element then we return mid index;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                // else if mid element is greater then target that means our target element may
                // be in first half of the array. So,
                r = mid - 1;
            } else {
                // else target element in second half of the array. So,
                l = mid + 1;
            }
        }
        return -1;
    }

    public static int[] searchRange(int[] nums, int target) {

        // find index of our target element
        int ind = binarySearch(nums, target);

        // intialize result with -1, -1
        int[] result = new int[] { -1, -1 };

        // if we havent found our element then return result
        if (ind == -1)
            return result;

        // traverse till on left side element is different then target element
        while (ind >= 0 && nums[ind] == target) {
            ind--;
        }

        // store index of left most element that is same as target in result
        result[0] = ind + 1;
        ind = ind + 1;

        // traverse till on right side element is different then target element
        while (ind < nums.length && nums[ind] == target) {
            ind++;
        }
        // store index of right most element that is same as target in result
        result[1] = ind - 1;

        // return result
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
}