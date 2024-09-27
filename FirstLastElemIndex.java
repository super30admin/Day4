package Day2;

class FirstLastElemIndex {
	
	// Time Complexity: O(log n)
    // Since we are doing binary search by reducing search space by half.
    
    // Space Complexity: O(1) 
    // No extra space used.
   
    // Did this code successfully run on Leetcode : Yes
    
    // Any problem you faced while coding this : No
	
    public int[] searchRange(int[] nums, int target) {
        
        // edge conditions
        if (nums == null || nums.length == 0) {
            return new int[]{-1,-1};
        }
        
        // calling the functions for performing binary search to find left and right occurrence of the target
        int firstOccur = binarySearchLeft(nums, target);
        int lastOccur = binarySearchRight(nums, target);
        
        return new int[]{firstOccur, lastOccur};
    }
    
    // function to perform binary search on left side of mid element
    public int binarySearchLeft(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length-1;
        
        while(start <= end) {
            int mid = start + (end-start)/2;
            // if element at mid index is same as target
            // check if element preceding the element at mid is lesser
            // if yes => we have got our first occurrence at mid
            // because it is a sorted array
            // if no => first occurrence can be between start & mid-1
            //          so, reset end pointer to (mid-1)
            if (nums[mid] == target) {
                if (mid == start || nums[mid-1] < nums[mid]) {
                    return mid;
                }
                else {
                    end = mid - 1;
                }
            }
            // if element at mid index > target
            // if yes, first occurrence should lie between start & mid-1 
            //          so, reset end pointer to (mid-1)
            else if (nums[mid] > target) {
                end = mid - 1;
            }
            // if element at mid index < target
            // if yes, first occurrence should lie between mid+1 & end 
            //          so, reset start pointer to (mid+1)
            else {
                start = mid + 1;
            }  
        }
        // if target not found anywhere in the given array
        return -1;   
    }
    
     // function to perform binary search on right side of mid element
    public int binarySearchRight(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length-1;
        
        while(start <= end) {
            int mid = start + (end-start)/2;
            
            // if element at mid index is same as target
            // check if element after the element at mid is greater
            // if yes => we have got our last occurrence at mid
            // because it is a sorted array
            // if no => first occurrence can be between mid+1 & end
            //          so, reset start pointer to (mid+1)
            if (nums[mid] == target) {
                if (mid == end || nums[mid+1] > nums[mid]) {
                    return mid;
                }
                else start = mid + 1;
            }
            // if element at mid index > target
            // if yes, last occurrence should lie between start & mid-1 
            //          so, reset end pointer to (mid-1)
            else if (nums[mid] > target) {
                end = mid - 1;
            }
            // if element at mid index < target
            // if yes, first occurrence should lie between mid+1 & end 
            //          so, reset start pointer to (mid+1)
            else {
                start = mid + 1;
            }  
        }
         // if target not found anywhere in the given array
        return -1;   
    }
    
    
}
