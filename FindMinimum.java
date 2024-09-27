// Time Complexity : O(log n) where n
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int findMin(int[] nums) {
        //Base 
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right){
            int midpoint = left + (right - left)/2;
            if(midpoint > 0 && nums[midpoint] < nums[midpoint-1]){ //Checks on the left of mid point
                return nums[midpoint];
            } else if (nums[left] <= nums[midpoint] && nums[midpoint] > nums[right]){ // Move on to the right side
                left = midpoint + 1;
            } else{
                right = midpoint - 1;
            }
        }
        return nums[left]; // returns min
    }
}