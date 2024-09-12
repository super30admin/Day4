// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : None

class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1)
            return nums[0];
        return search(nums,0,nums.length-1);
    }
    public int search(int[] nums,int low,int high){
        int mid= low+(high-low)/2;
        while(low<=high){            
             mid= low+(high-low)/2;
            if(mid==low){
                if(nums[mid]<nums[high])
                    break;
                else{
                    mid=high;
                    break;
                }
            }
            
            if(nums[mid]<nums[mid+1]&&nums[mid]<nums[mid-1])
                break;
            if(nums[mid]>nums[high])
                low=mid+1;
            else
                high=mid;
        }
       return nums[mid];
    }
}