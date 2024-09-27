package Day3;

class PeakElement {
    public int findPeakElement(int[] nums) {
    
    // Time Complexity: O(log n)
    // Since we are doing binary search by reducing search space by half.
    
    // Space Complexity: O(1) 
    // No extra space used.
   
    // Did this code successfully run on Leetcode : Yes
    
    // Any problem you faced while coding this : No
        
    // NOTE: At least one peak element will definitely lie on that side of the array which contains that neighbor element of mid indexed element such that neighbor element > mid indexed element.
        
        // edge cases
        if (nums == null && nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = nums.length-1;
        
        while (start <= end) {
            int mid = start + (end-start)/2;
             // checking if elem at mid is greater than both its neighbors or in case of boundary elements, greater than its single existing neighbor.
            if ((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1])) {
                return mid;
            }
            else if (nums[mid] < nums[mid+1]) {
                // peak element will be found in array part starting from (mid+1) to end.
                start = mid + 1;
            } 
            else {
                // peak element will be found in array part starting from start to (mid-1).
                end = mid - 1;
            }
        }
        return -1;
    }
}