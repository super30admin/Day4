// Time Complexity : O(log2(n))
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int findPeakElement(int[] nums) {
        // check if the array is null or empty
        if(nums == null || nums.length == 0) return -1;
        
        int low = 0;
        int high = nums.length - 1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            // if mid element is the peak element
            // and also check for boundary conditons
            if((mid == 0 || nums[mid] > nums[mid - 1]) && 
              (mid == nums.length -1 || nums[mid] > nums[mid + 1])){
                return mid;
            }else if(mid != 0 && nums[mid] < nums[mid - 1]){
            // if mid is not the first element of the array and if element previous to mid is greater than mid element
            // search on the left side of the array
                high = mid - 1;
            }else{
            // if element next to mid is greater than mid element 
            // search on the right side of the array
                low = mid + 1;
            }
        }
        return -1;  // element not found
    }
}