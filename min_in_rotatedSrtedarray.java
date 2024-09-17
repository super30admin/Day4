class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            // it is crucuial that the below if statement to be inside the while loop because at any iteration the 
            // low can be less than high and we might miss out on our min that way
            if(nums[low] <= nums[high]) {
                return nums[low];
            }
            int mid = low + (high - low) / 2;
            //min is always less than its surrounding values
            if((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            }
            // idea is to move towards unsorted section of array
            else if(nums[mid] >= nums[low]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return 90099090;
}
}