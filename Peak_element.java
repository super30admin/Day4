// ## Problem 3: (https://leetcode.com/problems/find-peak-element/)
// A peak element is an element that is greater than its neighbors.

// Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

// The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

// You may imagine that nums[-1] = nums[n] = -∞.

// Example 1:

// Input: nums = [1,2,3,1]
// Output: 2
// Explanation: 3 is a peak element and your function should return the index number 2.
// Example 2:

// Input: nums = [1,2,1,3,5,6,4]
// Output: 1 or 5 
// Explanation: Your function can return either index number 1 where the peak element is 2, 

//              or index number 5 where the peak element is 6.
// Note:

// Your solution should be in logarithmic complexity.



// Description: 
// The Peak element will be the element whose both adjacents will be smaller than the peak and if it is the last or starting element then we 
// have given a condition nums[-1] = nums[n] = -∞.
// What we will do is we will apply Binary search find the mid element and then we will move to that side which will have bigger element 
// because we will definitely find the peak element on that side.
// Also if in a question they would have asked about the first peak index or all the peak indexes then it wouldn't be possible to find with 
// binary search we would use Linear search for that
// Time Complexity :O (log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
class Solution {
    public int findPeakElement(int[] nums) {
        //initialized low and high to 0 and length-1 resprectively
        int low=0;
        int high=nums.length-1;
        //Base condition check
        if(nums==null || nums.length==0){
            return -1;
        }
        //calculated mid and did (high-low) to avoid overflow
        while(low<=high){
            int mid=low+(high-low)/2;
            //if the nums[mid] is greater than both the adjacent elements then it's the peak element. Also, if mid is low then we don't 
            // need to check nums[mid-1] and for mid==high nums[mid+1]
            if((mid==low || nums[mid]>nums[mid-1]) && (mid==high || nums[mid]>nums[mid+1])){
                return mid;
            }
            else{
                //if nums[mid+1] then we will move low to mid+1 else high to mid-1
                if(nums[mid+1]>nums[mid]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        //returning a random value
        return 345677;
    }
}