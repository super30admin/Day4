// S30 Big N Problem #7 {Medium}
// 34. Find First and Last Position of Element in Sorted Array
// Time Complexity : O(log n)+ O(log n) -> O(log n)
// Space Complexity :
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach
// running 2 binary search for finding upper bound and lower bound of the element
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left=leftSearch(nums,target,0,nums.length-1);
        int right=rightSearch(nums,target,0,nums.length-1);
        return new int[]{left,right};
    }
    private int leftSearch(int[] nums,int target, int low, int high){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(low==mid || nums[mid-1]<nums[mid]){
                    return mid;
                }else{
                    high=mid-1;
                }
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }     
        }
        return -1;
    }
    
    private int rightSearch(int[] nums,int target, int low, int high){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(high==mid || nums[mid+1]>nums[mid]){
                    return mid;
                }else{
                    low=mid+1;
                }
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }  
        }
        return -1;
    }
    
}
