// Time Complexity : O(log n)
// Space Complexity : 1
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// If array is sorted, first element is min.
// Check if left is is sorted, if not element will be in right unsorted part. 
// If left is unsorted element will be found in left unsorted array

// Your code here along with comments explaining your approach in three sentences only

class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int low = 0;
        int high = nums.length -1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[low] <= nums[high]){ // If first element less than last element min is first 
                return nums[low];
            }
            
            // check if middle is smallest element 
            if((mid == low || nums[mid] < nums[mid-1]) && (mid == high || nums[mid] < nums[mid+1])){
                return nums[mid];
            }
            if(nums[low] <= nums[mid]){ // check if left side is sorted, if not move to right side of array
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;        
    }
}