// Time Complexity: While searching for first occurence we are performing binary search so O(log(n)) again for last occurence O(log(n)) => O(log(n)) + O(log(n)) = O(log(n))
// Space Complexity: array of constant size and 3 variables of constant space are used so O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : was facing problem in understanding case of == mid element, on seeing solution of performing binary twice, understood.

// Your code here along with comments explaining your approach
class Solution {
    // Approach is to perform binary search twice to first get first occurence of repeating target and performing same for last occurence of repeating target
    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2];
        if(nums.length == 0) {
            arr[0] = -1;
            arr[1] = -1;
            return arr;
        }
        arr[0] = this.findFirst(nums, target, 0, nums.length-1);
        arr[1] = this.findLast(nums, target, 0, nums.length-1);

        return arr;
    }
    
    public int findFirst(int [] nums, int target, int low, int high) {
        int start = -1;
        while(high>=low) {
            int mid = low + (high-low)/2;
            // keep looping the binary search on left half and assigning mid to start until high becomes less than low, we achieve first occurence of target
            if(target<=nums[mid]) {
                high = mid-1;
            } else {
                low = mid+1;
            }
            if(target==nums[mid]) {
                start = mid;
            }
        }
        return start;
    }
    
    public int findLast(int[] nums, int target, int low, int high) {
        int end = -1;
        while(high>=low) {
            int mid = low + (high-low)/2;
            // keep looping the binary search on right half and assigning mid to end until high becomes less than low, we achieve first occurence of target
            if(target>=nums[mid]) {
                low = mid+1;
            } else {
                high = mid-1;
            }
            if(target==nums[mid]) {
                end = mid;
            }
        }
        return end;
    }
}