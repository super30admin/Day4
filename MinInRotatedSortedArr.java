/*
 * TC - O (log n)
 * SC - O (1)
 * One side is already sorted, so the min is either the smallest of the sorted side, or it lies on the other side. 
 * (Unless the array is not rotated at all, which we handle separately)
 * So start with the leftmost element as the min, check it against the mid and update. If the right side is sorted, min is on the left side,
 * else, min is on the right. 
 */
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if(nums[left] < nums[right]) return nums[left]; //already in correct order
        int mid = 0;
        int min = nums[left];
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(min > nums[mid]) min = nums[mid];
            if(nums[mid] < nums[right]) // min is on the left side
            {
                right = mid - 1;
            }
            else  // min is on the right side
            {
                left = mid + 1;
            }
        }
        return min;
    }
}
