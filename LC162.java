// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes	
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Create pointers low, high and calculate mid
//We start by checking if mid+1 is greater than mid. If true, we start our search in the right side of array as we have more chances of finding the peak value there. If false, move to the left side.
//Keep comparing mid+1 with mid until low <= high and keep updating low, high and mid.
//Base condition would check if mid is greater than mid+1 and mid-1. In such case, return mid.
//if not found, return -1.

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == nums.length - 1 || nums[mid + 1] < nums[mid])){
                return mid;
                
            } else if(nums[mid+1] > nums[mid]){
                low = mid + 1;
                
            } else{
                high = mid - 1;
                
            }
        }
        return -1;
        
    }
} 