------------------------------------------------------------------ Approach 1 ----------------------------------------------------------

// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        
        for(int i=1;i<nums.length-1;i++){
            if((nums[i-1]<nums[i]) && (nums[i]>nums[i+1])){
                return i;
            }
        }
        if(nums[0]>nums[1]){
            return 0;
        }
        
        if(nums[nums.length-1]>nums[nums.length-2]){
            return nums.length-1;
        }
        return -1;
    }
}

-------------------------------------------------------------------- Approach 2 -----------------------------------------------------------------------------
 // Time Complexity : ~O(logn)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int findPeakElement(int[] nums) {
        int low=0;
        int high = nums.length-1;
            
        while(low<=high){
            int mid= low +(high-low)/2;
            
            if((mid==0 || nums[mid-1]<nums[mid]) && (mid== nums.length-1 || nums[mid+1]< nums[mid])){
                return mid;
            }
            else{
                if(nums[mid]<nums[mid+1]){
                    low=mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
          return -1;
    }
}
