/* Time Complexity: O(logN) where N is the size of input array
 * Space Complexity: O(1)
 * LeetCode: Y (https://leetcode.com/problems/find-peak-element/)
 * NOTE TO SELF: Always check for ArrayIndexOutOfBoundsException and possibilities of TLE when working with a binary search
 * Approach: 
 *  Use the binary search. 
 *  If the middle element is a peak then return mid
 *  If you don't find the peak at middle element then a peak will be there at that side of the middle where there is a climbing slope.
 *  Note that nums[i] != nums[i + 1] so if a middle element is not a peak then a climbing scope will exist which may be the peak.
 *  Note that nums[-1] = nums[nums.length] = -INF
 */

class Solution {
    public int findPeakElement(int[] nums) {
        // Initiate the boundaries for binary search 
        int low = 0, high = nums.length - 1;
        
        // Keep searching for a peak till a valid search space exists
        while(low <= high) {
            // Calculate mid
            int mid = low + (high - low) / 2;
            
            // Check if nums[mid] is a peak
            if((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == high || nums[mid] >  nums[mid + 1])) {
                return mid;
            }
            // If the left of mid is a climbing slope then discard the right half
            else if((mid != low) && (nums[mid - 1] > nums[mid])) {
                high = mid - 1;
            }
            // If the right of mid is a climbing scope then discard the left half
            else if((mid != high) && (nums[mid] < nums[mid + 1])){
                low = mid + 1;
            }  
        }
               
        return -1;
    }
}
