// Time Complexity - O(logN)
// Space Complexity - O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// we use Binary Search to find the 1st occurence of the target and use the same Binary Search function to find the first occurence of a smallest number greater than target
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findElement(nums, target);
        int last = findElement(nums, target + 1) - 1;
        System.out.println(first + " " + last);
        
        if( first <= last)
            return new int[] {first, last};
        else 
            return new int[] {-1,-1};
    }
        
    private int findElement(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;
        int first_pos = nums.length;
                
        while(low <= high) {
            int mid = low + (high-low)/2;
            
            if(nums[mid] >= target) {
                first_pos = mid;
                high = mid -1;
            } else {
                low = mid + 1;
            }  
        }
        
        return first_pos;
    }
}