// Time Complexity :O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public int findMin(int[] nums) {
        return Find_minimum(nums,0,nums.length-1);
    }
    public int Find_minimum(int [] nums,int low,int high){
        if(low > high){
            return nums[0];
        }        
        
        int mid = low + (high - low)/2;
        if(mid < high && nums[mid]>nums[mid + 1]){
            return nums[mid + 1] ;
        }
        if(mid > low && nums[mid] < nums[mid - 1]){
            return nums[mid];
        }
        if(nums[low]<=nums[mid]){
            return Find_minimum(nums,mid+1,high);
        }
        return Find_minimum(nums, low, mid-1);       

    }
}