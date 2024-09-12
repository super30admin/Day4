// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0){
            return new int[]{-1,-1};
        }
        
        int[] result = new int[2];
        result[0]=firstRange(nums,target);//get first value
        result[1]=lastRange(nums,target); //get second value
        return result;
    }
    public int firstRange(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        int index = -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target){
                index = mid;
            }
            if(nums[mid]>=target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return index;
    }
    public int lastRange(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        int index = -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target){
                index = mid;
            }
            if(nums[mid]<=target){
                start = mid+1;
            }else{
                end = mid-1;                
            }
        }
        return index;
    }
}