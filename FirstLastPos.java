// Time Complexity : O(2*logn) = O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1,-1};
        int low = 0; int high = nums.length-1;
        int first = binarySearchFirst(nums, target, low, high);
        int last = binarySearchLast(nums, target, low, high);
        return new int[]{first,last};
    }    
    private int binarySearchFirst(int[] nums, int target, int low, int high){
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid] > nums[mid-1]) return mid;
                else {high = mid - 1;}
            }
            else if (nums[mid] < target) { low = mid + 1; }
            else { high = mid - 1; }             
        } return -1;
    }    
    private int binarySearchLast(int[] nums, int target, int low, int high){
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid] < nums[mid+1]) return mid;
                else {low = mid + 1;}
            }
            else if (nums[mid] < target) { low = mid + 1; }
            else { high = mid - 1; }             
        } return -1;
    }    
}
