/*
Leet Code Problem 162
Find Peak element
Language Used : Java
Link: https://leetcode.com/problems/find-peak-element/
Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Peak Element.
Memory Usage: 38.7 MB, less than 28.68% of Java online submissions for Find Peak Element.

Logic: Check for peak in binary search condition  
*/
class Solution {
    public int findPeakElement(int[] nums) {
        //Null check
        if(nums==null||nums.length==0) return -1;
        int low = 0;
        int high = nums.length - 1;
        while(low<=high){
            int mid = low + (high-low)/2;
            //Check if peak element
            if((mid==nums.length-1||nums[mid]>nums[mid+1])&&(mid==0||nums[mid]>nums[mid-1]))
            {
                return mid;
            }
            else if(nums[mid]<nums[mid+1])
            {
                low=mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
}