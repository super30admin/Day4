// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no



class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        int low=0;
        int high = nums.length-1;
        while(low<=high){            
            int mid = low+(high-low)/2;           
            //mid is peak 
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid==nums.length-1 || nums[mid]>nums[mid+1])){
                return mid;
            }else if(mid==nums.length-1 || nums[mid+1]>nums[mid]){
               //move to higher element side,here right
                low = mid+1; 
            }
            else{
                high = mid-1;
            }            
        }        
    return -1;        
    }
}
