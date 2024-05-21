// Time Complexity : For 1st binary search - O(log n) + For 2nd binary search - O(log n) => O(log n)
// Space Complexity : O(1) => Constant space compleexity as we are not utizlizing additional space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Got TLE as calculated value of mid outside while loop

/*
Approach: To search 1st index, compared mid element with target, if it is equal then checked the left neighbour. If left neighbour is not equal then return mid else move to LHS.
To search last index, compared mid element with target, if it is equal then checked the right neighbour. If right neighbour is not equal then return mid else move to RHS.
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || nums == null)
            return new int[] { -1, -1 };
        int first = searchFirstIndex(nums, target);
        //If unable to find the first index then it indicates element doesn't exist
        if (first == -1)
            return new int[] { -1, -1 };
        int last = searchLastIndex(nums, target);

        return new int[] { first, last };
    }

    private int searchFirstIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; //prevents integer overflow
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1] != target){
                    return mid;
                }
                high = mid -1;  //Move to LHS if element on the left of mid is equal to target
            }
            else if(target < nums[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    private int searchLastIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2; //prevents integer overflow
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid+1] != target){
                    return mid;
                }
                low = mid + 1; //Move to RHS if element on the right of mid is equal to target
            }
            else if(target < nums[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }return-1;
    }
}