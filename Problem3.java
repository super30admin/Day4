// Time Complexity - O(LogN)
// Space Complexity - O(1)
// This Solution worked on LeetCode

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length ==0){
            return -1;
        }
       // if(nums.length ==1) return 0;
        int low =0;
        int high = nums.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            //Base Case
            if((mid ==0 || nums[mid] > nums[mid-1]) && 
               (mid == nums.length-1 || nums[mid] > nums[mid+1]))
                return mid;
            if(nums[mid] < nums[mid+1] && mid != nums.length-1){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
}
