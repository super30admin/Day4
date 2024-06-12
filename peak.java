//Tiime - O(log n) and space is constant
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1)
        {
            return 0;
        }
        if(nums.length == 2)
        {
            if(nums[0] > nums[1])
            {
                return 0;
            }
            return 1;
        }
        int low = 0;
        int high = nums.length - 1;
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            int prev = (mid - 1 + nums.length) % nums.length;
            int next = (mid + 1) % nums.length;
            //if((mid == 0 || nums[mid - 1] <= nums[mid]) && (mid == nums.length - 1 || nums[mid + 1] <= nums[mid]))
            if(nums[prev] <= nums[mid] && nums[next] <= nums[mid])
            {
                return mid;
            }
            else if(nums[mid] < nums[prev])
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return -1;
    }
}
