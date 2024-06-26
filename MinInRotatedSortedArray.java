/*
 Time Complexity : O(log n)
 Space Complexity : O(1)
 Solved on leetcode? yes

 Approach:
 If the array is rotated, the answer will always lie in the unsorted part of the array.
 */
class Solution {
    public int findMin(int[] nums) {
        if(nums[0] <= nums[nums.length - 1])
            return nums[0];
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            System.out.println(mid);
            if(nums[low] <= nums[high])
                return nums[low];
            if(mid>0 && nums[mid] < nums[mid-1]) {
                return nums[mid];
            } else if(nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 999;
    }
}