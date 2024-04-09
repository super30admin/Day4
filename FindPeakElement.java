// Climbing towards the larger value in the slope will give us a peak value


// Time Complexity- O(logN), Space Complexity- O(1)

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length -1;
         while(low<=high){
            int mid = low+(high-low)/2;
            if((mid == 0||nums[mid]>nums[mid-1]) &&( mid==high || nums[mid]>nums[mid+1])){
                return mid;
            } else if(nums[mid]<nums[mid+1]){
                low = mid+1;
            } else {
                high = mid - 1;
            }
         }
        return -1;
    }
}