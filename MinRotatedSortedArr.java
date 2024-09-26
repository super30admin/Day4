class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = (nums.length - 1);
        int mid = 0;
        while(low <= high){
            mid = low + (high - low) /2;
            if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.length -1 || nums[mid] < nums[mid+1])){
                return nums[mid];
            }else if(nums[mid] > nums[high]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
}

// Time Complexity - BigO(log(n))
// Space Complexity - BigO(1)