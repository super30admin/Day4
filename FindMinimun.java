/** Executed on LeetCode: No Problems */

/** Time Complexity: O(log n) 
 * Spache Complexity: O(1)
*/

/** Explanation:
 * Apart from binary normal binary search to find a pivot element we need to consider 3 edge cases (discovered after submitting to leetcode)
 * When length of the array is 1
 * When the array is already sorted
 * When the first calculated mid is your Pivot/minimum
 * 
 * This question opened my mind a bit more on how to think about edge cases when you have pivots/inflection points.
*/

class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        
        if (len == 1 || nums[0] < nums[len - 1]) {
            return nums[0];
        } 
        
        int result = findPivot(nums);
        return nums[result];
    }
    
    private int findPivot(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low)/2;
            
            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            } else if (nums[mid - 1] > nums[mid]) {
                return mid;                
            } else if (nums[mid] > nums[low]) {
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        
        return 0;
    }
}