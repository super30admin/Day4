// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : figuring out the code for edge cases when index is at 0 or at nums.length - 1

public class FirstLastPosition {
    public int[] searchRange(int[] nums, int target) {
        
        return new int[]{searchLeft(nums, target), searchRight(nums, target)};
        
    }
    
    // Function to search the left most index
    public int searchLeft(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high) {
            
            int mid = (low+high) / 2;
            
            if (nums[mid] == target) {

                //If mid is at zero, it's the minimum index
                if(mid == 0) {
                    return mid;

                // If element at mid is not equal to its left neighbor, minimum index is found    
                } else if(nums[mid] != nums[mid -1 ]) {
                    return mid;

                // Else, keep searching the left array    
                } else {
                    high = mid -1 ;
                }
            } 
            
            else if(nums[mid] > target) {
                high = mid - 1;
            } 
            
            else {
                low = mid + 1;
            }
            
        }
        
        return -1;
        
    }
    
    // Function to search the right most index
    public int searchRight(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high) {
            
            int mid = (low+high) / 2;
            
            if (nums[mid] == target) {

                //If mid is at last element, it's the maximum index
                if(mid == nums.length - 1) {
                    return mid;

                // If element at mid is not equal to its right neighbor, maximum index is found    
                } else if(nums[mid] != nums[mid + 1 ]) {
                    return mid;

                // Else, keep searching the right array 
                } else {
                    low = mid + 1 ;
                }
            } 
            
            else if(nums[mid] > target) {
                high = mid - 1;
            } 
            
            else {
                low = mid + 1;
            }
            
        }
        return -1;
        
    }
}