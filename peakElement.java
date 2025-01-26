//Problem 3: (https://leetcode.com/problems/find-peak-element/)

//  Time Complexity : O(logn) - binary search
//  Space Complexity : O(1) - constant
//  Did this code successfully run on Leetcode : yes
//  Any problem you faced while coding this : no


//  Your code here along with comments explaining your approach in three sentences only

/*
 * Here we are finding the element that has both its neighbours less than itself. We first check if mid is higher, if it is not then we will
 * move in the direction of the neighbour element that is higher than mid.
 */

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if((mid==0||nums[mid]>nums[mid-1]) && (mid==n-1||nums[mid]>nums[mid+1])){
                return mid;
            }
            else if(nums[mid]<nums[mid+1]){
                low = mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}

