//Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

//  Time Complexity : O(logn) - binary search
//  Space Complexity : O(1) - constant
//  Did this code successfully run on Leetcode : yes
//  Any problem you faced while coding this : no

/*
 * Here, we may have completely sorted array or rotated sorted array. So, in case of completely sorted array we get 1st element as the
 * minimum element. If that is not the case we now try to find using the mid. if mid is greater than the right element then, that right element
 * is the min. if mid is lower than the left element then mid is the minimum. In other case, we compare with the number at low an and number at 
 * high. If number at low is less than num at mid then we move towards the right to find if there is any element still less else we move right.
 */

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            //fully sorted array
            if(nums[low]<=nums[high]){
                return nums[low];
            }
            //
            int mid = low+(high-low)/2;
            if((mid==0||nums[mid]<nums[mid-1]) && ((mid==n-1)||(nums[mid]<nums[mid+1]))){
                return nums[mid];
            }
            else if(nums[low]<=nums[mid]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
    return -1;
    }
}

