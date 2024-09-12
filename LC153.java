// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes	
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Create pointers low, high and calculate mid
//We start by checking if the mid value is greater than high. If true, we start our search in the right side of the array. Else we move to the left side of the array until low //<= high.
//We would check if mid is smaller than its left and right value. In such case, we have found our minimum value and return the mid.
//If not found, return -1.


class Solution {
    public int findMin(int[] nums) {
        
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.length -1 || nums[mid] < nums[mid + 1])){
                
                return nums[mid];
            }
            else if(nums[mid] > nums[high]){
                low = mid + 1;
                
            } 
            else{
                high = mid - 1;
                
            }
        }
        return -1;
        
    }
}

