Problem 2: Find min in rotated sorted array
// Time Complexity : O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach in three sentences only

//Check for the rotated sorted half 
//compare the left and the right element 
//if the left element is smaller move to the left and vice versa
// in this way we will reach to the minimum in an array

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = left + (right-left)/2;
            //Left half is sorted
            if(nums[left]<=nums[mid]){
                
                if(nums[left]<nums[right]){
                    right = mid;
                }else{
                    left = mid+1;
                }
            }else{
                if(nums[right]<nums[left]){
                    right = mid;
                }else{
                    left = mid+1;
                }
            }
        }
        return nums[left];
    }
}