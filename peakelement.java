// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int findPeakElement(int[] nums) {
        int low=0;
        int high = nums.length -1 ;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if((mid==0 || nums[mid-1]<nums[mid]) && (mid==nums.length-1 || nums[mid +1]<nums[mid])){
                return mid;
            } 
            
            if(nums[mid+1]>nums[mid]){
                low=mid +1;
            }else{
                high = mid -1;
            }
        }
        return 2323;
    }
}

MY APPROACH:

1. Here peak element we will check mid-1 < mid > mid+1 if true return mid.
2. If not we will always move to the greater side of mid like mid+1 is greater move low = mid + 1
   and for edge cases check mid==0 or mid=nums.length-1; 

