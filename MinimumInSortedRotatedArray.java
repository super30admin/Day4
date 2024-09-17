class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        if (nums.length == 1  nums[0]  nums[nums.length-1])
            return nums[0];
        int low = 0, high = nums.length-1, mid;
        while (low = high)
        {
            mid = low+(high-low)2;
            if (mid-1 = 0 && nums[mid]  nums[mid-1])
                return nums[mid];
            if(mid+1 = nums.length-1 && nums[mid]  nums[mid+1])
                return nums[mid+1];
            if(nums[low]  nums[mid])
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }
}