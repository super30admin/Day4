/*
 * TC - O (log n)
 * SC - O (1)
 * Note that there will be a peak towards the higher element from any given element. (Unless the given element is the peak). 
 * So find a mid and using binary search, go towards the higher side.
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1, mid = 0;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(mid != nums.length - 1 && nums[mid] < nums[mid + 1]) // there is a peak to the right 
            {
                left = mid + 1;
            }
            else if(mid != 0 && nums[mid] < nums[mid - 1]) // there is a peak to the left 
            {
                right = mid - 1;
            }
            else // the mid is the peak
            {
                return mid;
            }
        }
        return mid;
    }
}
