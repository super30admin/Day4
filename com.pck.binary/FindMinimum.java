class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            if(nums[low] <= nums[high]){
                return nums[low];
            }
            int mid = low + (high - low) / 2;
            if((mid == low || nums[mid - 1] > nums[mid]) && (mid == high || nums[mid] < nums[mid + 1])){
                return nums[mid];
            }
            if(nums[mid] >= nums[low]){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return nums[low];
    }
}