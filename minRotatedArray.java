//Time complexity: O(logn)
//Space Complexity : O(1)
//Compiled in leetcode

class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int mid = l+(r-l)/2;
        int min = 5001;
        while(l<=r)									
        {
            if((mid==0 || nums[mid]<nums[mid-1]) && (mid== nums.length - 1 || nums[mid]<nums[mid+1]))  //if mid is less than neighbours returning mid. // mid is 0 or last and is less than neighbour returning mid.
                return nums[mid];
            else if(nums[r] < nums[mid])				//if mid is greater than last disregarding first part as min will be between mid and right. rotated sorted array.
            {
                l = mid+1;
            }
            else										//else disregarding right part.
            {
                r = mid-1;
            }
            mid = l+(r-l)/2;
        }
        return -1;
    }
}