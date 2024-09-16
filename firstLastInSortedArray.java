// Time Complexity : O(LogN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] searchRange(int[] nums, int target) {
        //if given array is null
        if(nums==null||nums.length==0)
            return new int[] {-1,-1};
        //checking if the given target is less or greater than 1st and last index of the array values
        if(target<nums[0]||target>nums[nums.length-1])
            return new int[] {-1,-1};
        //then apply binary search for 1st index of the target
        int firstIndex=firstBinarySearch(nums, target);
        //if not able to find first occurence
        if(firstIndex==-1) 
            return new int[] {-1,-1};
        //then find 2nd occurence
        int secondIndex=secondBinarySearch(nums, target);
        return new int[] {firstIndex, secondIndex};
    }
     private int firstBinarySearch(int[] nums,int target){
        int low=0,high=nums.length-1;
        while(low<=high){
            int midValue=low+(high-low)/2;
            if(nums[midValue]==target){
                //then check the value of left element is smaller or not
                if(midValue==0||nums[midValue-1]<nums[midValue]){
                    return midValue;
                }
                else{
                    high=midValue-1;
                }
            }
            else if(target<nums[midValue]){
                high=midValue-1;
            }
            else{
                low=midValue+1;
            }
        }
        return -1;
    }
    private int secondBinarySearch(int[] nums,int target){
        int low=0,high=nums.length-1;
        while(low<=high){
            int midValue=low+(high-low)/2;
            if(nums[midValue]==target){
                //then check the value of left element is smaller or not
                if(midValue==nums.length-1||nums[midValue+1]>nums[midValue]){
                    return midValue;
                }
                else{
                    low=midValue+1;
                }
            }
            else if(target<nums[midValue]){
                high=midValue-1;
            }
            else{
                low=midValue+1;
            }
        }
        return -1;
    }
   
}