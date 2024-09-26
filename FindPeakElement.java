// Time Complexity : O(log base 2 n)
// Space Complexity : O(log base 2 n) recursive tree, reduced in half every time
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : n/a

class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        return find(nums,start,end);
        
    }
    
    private int find(int[] nums, int start, int end){
        // peak found
        if (start == end) return start;
        
        int mid = (start + end) / 2;
        
        // recursive call - update
        if (nums[mid] > nums[mid+1]){ // descending order - search left side
            return find(nums,start,mid);
        }
        
        else{
            return find(nums,mid+1,end);
        }
        
    }
}