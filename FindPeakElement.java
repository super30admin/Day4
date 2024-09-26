

// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
/*
Approach
1) apply binary search and check for mid value
2) if the element is found in mid we check for conditions if the element lies in the end or maybe at the start position
3) if the condition is statisfied then return mid.
4) otherwise check for if the elenent at mid and the next value if(nums[mid]<nums[mid+1])
we can try to search in later half as we can find the peak element in next half
5) otherwise we try searching in previous half.
and we shift the end to mid -1 value.



*/

class Solution {
    public int findPeakElement(int[] nums) {
       
       int start =0;
        int end = nums.length-1;
        
        while(start<=end)
        {
            int mid = start+(end-start)/2;
            
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid==nums.length-1 || nums[mid]>nums[mid+1]))
            {
                return mid;
            }
            else if(nums[mid]<nums[mid+1])
            {
                start = mid+1;
            }
            else
            {
                end = mid-1;
            }
        }
        
        
        return -1;
    }
}