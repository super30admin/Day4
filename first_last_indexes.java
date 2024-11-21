//TC: O(log n)
//SC : O(1)
//Leetcode : successful

//Description: Take two variables and perform binary search when the target is found, on the left side for first and right side of target index to find the last index and return those values

class Solution {
    public int[] searchRange(int[] nums, int target) {
       int first = -1;
       int last = -1;

       if (nums.length == 0) {
           return new int[]{first, last};
       }

       int start = 0;
       int end = nums.length - 1;

       while (start <= end) {
           int mid = (start + end) / 2;

           if (nums[mid] == target) {
               first = mid;
               end = mid - 1;
           } 
           else if (nums[mid] > target) {
               end = mid - 1;
           }
           else {
               start = mid + 1;
           }
       }

       start = 0;
       end = nums.length - 1;

       while (start <= end) {
           int mid = (start + end) / 2;

           if (nums[mid] == target) {
               last = mid;
               start = mid + 1;
           } 
           else if (nums[mid] > target) {
               end = mid - 1;
           }
           else {
               start = mid + 1;
           }
       }

       return new int[]{first, last};
   }
}