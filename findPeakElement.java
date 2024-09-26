// Time Complexity :o(log n)
// Space Complexity :o(1)  
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

class Solution {
    public int findPeakElement(int[] nums) {
        int low=0;
        int high=nums.length-1;
        
        if(nums.length==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[high]>nums[high-1]) return high;
        while(low<high){
            int mid=low+(high-low)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }else if(nums[mid-1]>nums[mid]){
                high=mid;
            }else{
                low=mid;
            }
        }
        
        return -1;
        
    }
}