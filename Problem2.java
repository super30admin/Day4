// Time Complexity : O(logn)
// Space Complexity : O(1)

// The code efficiently finds the smallest element in a rotated sorted array `nums` using binary search.
// It initializes `low` and `high` indices to track the array range and adjusts them based on comparisons with the middle element (`mid`).
// By ensuring proper boundary adjustments, the algorithm reliably converges to the smallest element, delivering optimal performance for finding the minimum value in rotated sorted arrays.

class Solution {
    public int findMin(int[] nums) {
       
       if(nums.length == 0){
        return 0;
       }

       int low = 0;
       int high = nums.length -1;
       
       while(low <=high){
         int mid = low + (high-low)/2;
         if((mid ==0 || nums[mid-1] > nums[mid]) && (mid == nums.length-1 || nums[mid] < nums[mid+1])){
            return nums[mid];
         }else if(nums[mid] < nums[high]){
            high = mid-1;
         }else{
            low = mid+1;
         }
       }
       return nums[low];
    }
}