package Day3;

class MinRotatedSortedArray {
    public int findMin(int[] nums) {
        
    // Time Complexity: O(log n)
    // Since we are doing binary search by reducing search space by half.
    
    // Space Complexity: O(1) 
    // No extra space used.
   
    // Did this code successfully run on Leetcode : Yes
    
    // Any problem you faced while coding this : No
        
    // NOTE: Min element will always lie on unsorted side of the rotated sorted array.
        
        // Edge cases
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = nums.length-1;
        
        while (start <= end) { 
            
            // if array is sorted itself, then elem at start index will be least element
             if (nums[start] < nums[end]) {
                return nums[start];
             }
        
            int mid = start + (end-start)/2;
            // checking if elem at mid is less than both its neighbors or in case of boundary elements, less than its single existing neighbor.
            if ((mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.length-1 || nums[mid] < nums[mid+1])) {
                return nums[mid];
            }
            else if (nums[start] <= nums[mid]) {
                // left side is sorted
                // min lies on right unsorted side
                start = mid+1;                
            } else {
                // right side is sorted
                // min lies on left unsorted side
                end = mid-1;
            }   
        }
        
        return -1;
    }
}
