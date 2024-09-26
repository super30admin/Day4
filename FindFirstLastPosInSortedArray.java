// Time Complexity : Linear Search - O(2N) - O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES

class Solution {
    public int[] searchRange(int[] nums, int target) {
         int first = -1 ;
         int last = -1;
         for ( int i = 0; i < nums.length; i++){
             if (nums[i] == target)
             {
                 first = i;
                 break;
             } 
         }
        for ( int i = nums.length-1; i >= 0; i--) {
             if (nums[i] == target)
             {
                 last = i;
                 break;
             }             
         }
        return new int[]{first,last};
    }
}

