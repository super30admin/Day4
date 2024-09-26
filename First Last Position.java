// Time Complexity : O(log2(n))
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    
    // method to find the first index of occurrence (on left side)
    private int leftSearch(int [] nums, int target){
        int low = 0; 
        int high = nums.length - 1;
        while(low<=high){
            int mid = low + (high-low)/2;
            
            // if mid element is our target
            if(nums[mid] == target){
                
                // check if element at mid is the first element of the array or
                // if element at mid is greater than its previous element
                
                if(mid == 0 || nums[mid] > nums[mid -1]){
                    return mid;
                }else{
                    // keep moving left
                    high = mid - 1;
                }
            }else if(nums[mid] > target){
                // the element lies on the left side of mid
                high = mid - 1 ;
            }else{
                // the element lies on the right side of mid
                low = mid + 1;
            }
        }
        return -1; // element not found
        
    }
    
    // method to find the last index of occurrence (on right side)
    private int rightSearch(int [] nums, int target){
    int low = 0; 
    int high = nums.length - 1;
    while(low<=high){
        int mid = low + (high-low)/2;

        // if mid element is our target
        if(nums[mid] == target){
            
            // check if element at mid is the last element of the array or
            // if element at mid is less than its next element
            
            if(mid == nums.length - 1 || nums[mid] < nums[mid + 1]){
                return mid;
            }else{
                // keep moving right
                low = mid + 1;
            }
        }else if(nums[mid] > target){
            // the element lies on the left side of mid
            high = mid - 1 ;
        }else{
            // the element lies on the right side of mid
            low = mid + 1;
        }
    }
    return -1;
}
    
    
    public int[] searchRange(int[] nums, int target) {
        //check if array is null or empty
        if(nums == null || nums.length == 0) return new int []{-1,-1}; 
        
        // if target element is outside the range of sorted array
        if(nums[0] > target || nums[nums.length-1] < target ) return new int []{-1,-1}; //
        
        // search for the first occurrence of the target element
        int first = leftSearch(nums, target);
        
        // if there is no first occurence of element, then return -1, -1
        if(first == -1) return new int []{-1,-1};
        
        // search for the last occurrence of the target element
        int last = rightSearch(nums, target);
        return new int []{first,last};
                
    }
}