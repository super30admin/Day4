// Time Complexity : O(logn) ;(n is the no.of elements in array)  
// Space Complexity : O(1) ; no auxilary space needed
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//CODE

//We are first finding the first occurence of target using binary search , so the half of the array will be ignored as we have to search in the left side ignoring right side of the array . And in the same way for finding the last occurence of target we will search in right part of the array ignoring the left side.

public class first_and_last_position_of_element_in_sorted_array {
    class Solution {
        int first;

        private int binarySearchLeft(int[] nums, int low, int high, int target) {
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] == target) { // if mid element is the target
                    if (mid == 0 || nums[mid - 1] < nums[mid]) { // if target found at mid element is the first element
                                                                 // of array or mid element is greater than mid-1 ;so
                                                                 // that is the first occurence of target
                        return mid;
                    } else {
                        high = mid - 1;      //if it is not the first occurence ,then search on left side of mid
                    }
                } else if (target > nums[mid]) {   //if target is greater than mid ,then it means target is present at right side of mid
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }

        private int binarySearchRight(int[] nums, int low, int high, int target) {
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] == target) {
                    if (mid == nums.length - 1 || nums[mid] < nums[mid + 1]) {   //if target element found at mid is the last element in array or element at mid is smaller than element at mid+1 ,then that element is tha last occurence od target
                        return mid;
                    } else {
                        low = mid + 1;    //if mid element is not the last occurence ,then search on right side of mid
                    }
                } else if (target > nums[mid]) {    //if target is greater than mid ,then it means target is present at right side of mid
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }

        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0)
                return new int[] { -1, -1 }; // null case
            if (nums[0] > target || nums[nums.length - 1] < target) // if the target is not is not present in array
                return new int[] { -1, -1 };
            first = binarySearchLeft(nums, 0, nums.length - 1, target); // binary search for finding first occurence of
                                                                        // target
            if (first == -1)
                return new int[] { -1, -1 }; // if target is not found in first binary search ,then the target is not in
                                             // array
            int last = binarySearchRight(nums, first, nums.length - 1, target); // binary search for finding last
                                                                                // occurence of target
            return new int[] { first, last };
        }
    }

}
