// Time Complexity :O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start<=end) {
            int mid = start + (end-start)/2;
            if(nums.length == 1){
                return 0;
            }
            if(mid==0 && nums[mid+1]<nums[mid]){
                return mid;
            }
            if(mid == nums.length-1 && nums[mid-1]<nums[mid]) {
                return mid;
            }
            if(mid-1>=0&&nums[mid-1]<nums[mid] && mid+1<nums.length &&nums[mid]>nums[mid+1]) {
                return mid;
            }
            if(nums[mid+1]>nums[mid]) {
                start = mid+1;
            }
            else if(nums[mid-1]>nums[mid]) {
                end = mid-1;
            }
        }
        return 2;
    }
}