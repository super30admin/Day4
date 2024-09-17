// Time Complexity : O(log2(n))
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int findMin(int[] nums) {
         // check if the array is null or empty
        if(nums == null || nums.length == 0) return -1;
        
        int low = 0;
        int high = nums.length - 1;
        
        while(low<=high){
            // if the sub array is sorted, return the first element of array
            if(nums[low] < nums[high]) return nums[low];
            
            int mid = low + (high-low)/2;
            
            // check if mid is greater than its neighbors
            // and also check for boundary condition
            if((mid==0 || nums[mid] < nums[mid-1]) && (mid == nums.length-1 || nums[mid] < nums[mid+1])){
                return nums[mid];   
            }else if(nums[low] <= nums[mid]){
                //if left side is sorted, move to right side
                low = mid + 1;
            }else{
                //if right side is sorted so move to left side
                high = mid - 1;
            }
            
        }
        return -1;
    }
}