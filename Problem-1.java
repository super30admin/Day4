
// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        while(start<=end) {
            int mid = start + (end-start);
            if(nums[mid]==target) {
                if(mid<i) 
                    i = mid;
            }
            if(nums[mid]>=target) {
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        start =0;
        end = nums.length-1;
        while(start<=end) {
            int mid = start + (end-start);
            if(nums[mid]==target) {
                if(mid<j) 
                    j = mid;
            }
            if(nums[mid]>target) {
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        int[] index = new int[2];
        if(i == Integer.MAX_VALUE) 
            i=-1;
        if(j == Integer.MAX_VALUE) 
            j=-1;
        index[0] = i;
        index[1] = j;
        return index;
    }
}