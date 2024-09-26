// Time Complexity : 0(log n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Keep in mind edge conditions like mid > 0

class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;

        if(nums.length == 1)
            return nums[0];

        int low = 0, high = nums.length - 1;
        while(low < high){
            int mid = low + (high - low)/2;

            //return when you see mid less than previous
            if(mid > 0 && nums[mid] < nums[mid-1])
                return nums[mid];

            else if(nums[low] <= nums[mid] && nums[mid] > nums[high])
                low = mid + 1;

            else
                high = mid - 1;
        }

        return nums[low];
    }
}