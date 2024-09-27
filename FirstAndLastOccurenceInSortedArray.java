// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class FirstAndLastOccurenceInSortedArray {
    class Solution {
        int first;

        private int binarySearchLeft(int[] nums, int low, int high, int target) {
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] == target) { 
                    if (mid == 0 || nums[mid - 1] < nums[mid]) {

                        return mid;
                    } else {
                        high = mid - 1;      
                    }
                } else if (target > nums[mid]) {   
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
                    if (mid == nums.length - 1 || nums[mid] < nums[mid + 1]) { 
                        return mid;
                    } else {
                        low = mid + 1;   
                    }
                } else if (target > nums[mid]) {   
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }

        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0)
                return new int[] { -1, -1 }; 

            if (nums[0] > target || nums[nums.length - 1] < target) 
                return new int[] { -1, -1 };
                first = binarySearchLeft(nums, 0, nums.length - 1, target); 

            if (first == -1)
                return new int[] { -1, -1 };

            int last = binarySearchRight(nums, first, nums.length - 1, target); 

            return new int[] { first, last };
        }
    }

}