Problem 2: Find min in rotated sorted array
// Time Complexity : O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach in three sentences only

//Find the mid and move left if the left element is greater than right 
//or move right if the right element is greater than left in this way we will find the peak element


class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = left + (right-left)/2;
            if(nums[mid+1]>nums[mid]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}

