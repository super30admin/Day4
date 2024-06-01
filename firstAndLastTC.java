// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[] {-1,-1};
        }
        int first = binarySearchFirst(nums, target); // searching first element
        if(first == -1){ // if there is no forst element, then no use of finding the last elemet as well. Simply return -1,-1
            return new int[] {-1,-1}; 
        }
        int second = binarySearchSecond(nums, target); // searching second element
        return new int[] {first, second}; // return the positions
    }

    private int binarySearchFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2; // prevent integer overflow
            if (nums[mid] == target) { // mid element is target
                if (mid == low || nums[mid - 1] != target) { // element left of mid is not target
                    return mid;
                }
                high = mid - 1; // shorten the search moving left
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private int binarySearchSecond(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2; // prevent integer overflow
            if (nums[mid] == target) {
                if (mid == high || nums[mid + 1] != target) {
                    return mid;
                }
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

}