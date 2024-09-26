// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // base case 
        if(nums == null || nums.length == 0) return new int[] {-1, -1};

        // if element does not lie in array between the lower and higher value of sorted array
        if(target < nums[0] || target > nums[nums.length - 1]) return new int[] {-1, -1};

        // perform binary search to find first pos which will always lie on left side because it's a sorted array
        int firstPos = binarySearchFirstLeft(nums, target);

        // if we did not find out target that means no need to do binary search for second part
        if(firstPos == -1) {
            return new int[] {-1, -1};
        }

        // perform binary search to find last pos which will always lie on right side because it's a sorted array
        // we can set our low as firstPos insead of 0
        int secondPos = binarySearchSecondRight(nums, target, firstPos);

        return new int[] {firstPos, secondPos};
    }

    private int binarySearchFirstLeft(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        // perform normal binary search
        while(low <= high) {
            int mid = low + (high - low) / 2;

            // if target is found
            if(nums[mid] == target) {
                // we need to check if left element is also target or not
                // if not that means we found first position of target
                // also take care of boundry condition when mid will be at 0
                if(mid == low || nums[mid - 1] < nums[mid]) {
                    return mid;
                }
                else { // else we will continue our binary search by moving high pointer as below
                    // we are moving high pointer because it's a sorted array and we have find first position of target which will lie on left side only
                    high = mid - 1;
                }
            }
            else if(nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        // if not found return -1
        return -1;
    }

    private int binarySearchSecondRight(int[] nums, int target, int firstPos) {
        int low = firstPos;
        int high = nums.length - 1;

        // perform normal binary search
        while(low <= high) {
            int mid = low + (high - low) / 2;

            // if target is found
            if(nums[mid] == target) {
                // we need to check if right element is also target or not
                // if not that means we found last position of target
                // also take care of boundry condition when mid will be at last index of array
                if(mid == high || nums[mid + 1] > nums[mid]) {
                    return mid;
                }
                else { // we are moving low pointer because it's a sorted array and we have find last position of target which will lie on right side only
                    low = mid + 1;
                }
            }
            else if(nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        // if not found return -1
        return -1;
    }
}