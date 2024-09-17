class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;


        if(nums[low] < nums[high])
            return nums[low];

        while(low < high-1) {
            int mid = (low+high)/2;
            if(nums[low] > nums[mid])
                high = mid;
            else
                low = mid;
        }
        return nums[high];
    }
}