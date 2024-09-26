// Time Complexity : O(log n) - Binary Search
// Space Complexity : O(1) no extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing SPecific

//Using binary search we can try to check peak exists on which side and search the side till we find peak
//Check if mid is less than its right element, then there exists a peak definitely in the right side
//else find the peak in the left side.

class Solution {
    public int findPeakElement(int[] nums) {
        int low=0;
        int high=nums.length-1;
        if(nums.length==1) return 0;
       
        
        
        while(low<high){
            int mid=low+(high-low)/2;
            
            if(nums[mid]<nums[mid+1]){
                low=mid+1;}
            else{
                high=mid;
            }
            }
        return low;
        
       
        
    }
}