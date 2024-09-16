/**
Time Complexity : O(log n), where n is the number of elements in the array
Space Complexity : O(1)
Solved on LeetCode : Yes
 */

 //Approach: Binary Search
//  1. We need to apply 2 binary searches. One to get the first occurrence and the second one to get the last occcurrence.
// 2. If the target is equal to the mid element, then we check for its neighbors.
// 3. If they are the same, we reduce the search space by moving left to find the first occurrence and right to get the last occurrence.

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int firstPosition = getFirstPosition(nums, target, left, right);
        int lastPosition = getLastPosition(nums, target, left, right);
        return new int[] {firstPosition, lastPosition};
    }
    
    public int getFirstPosition(int[] nums, int target, int left, int right) {
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(nums[mid] == target) {
                if(mid == 0 || nums[mid-1] < target) 
                    return mid; //here mid would be the first occurrence because the element to the left of it is smaller than it
                    right = mid - 1; //move left because we are trying to find the first occurrence
            }
            else if(nums[mid] > target) {
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return -1;
    }
    
    public int getLastPosition(int[] nums, int target, int left, int right) {
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(nums[mid] == target) {
                if(mid == nums.length-1 || nums[mid + 1] > target) 
                    return mid; //mid would be the last occurrence because the element to the right of it is bigger than it.
                left = mid + 1; // move right
            }
            else if (nums[mid] > target) {
                right = mid - 1; //move left
            }
            else
                left = mid + 1;
        }
        return -1;
    }
}