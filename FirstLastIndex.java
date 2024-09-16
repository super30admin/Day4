// Time complexity -> O(logn + logn) -> O(2logn) -> O(log n)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {startingpoint(nums, target), endingpoint(nums, target)};
    }
    
    public int startingpoint(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        // Start Binary Search 
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(nums[mid] == target){
                // Break point 
                if(mid == 0 || nums[mid - 1] != target){
                    return mid;
                }
                // keep moving left
                high = mid - 1;
            }
            else if (nums[mid] < target){
                // move right
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        // If nothing is found
        return -1;
    }
    
    public int endingpoint(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        // Start Binary Search 
        while(low<=high){
            int mid = low + (high - low) / 2;
            
            if(nums[mid] == target){
                // Break point 
                if(mid == nums.length-1 || nums[mid + 1] != target){
                    return mid;
                }
                // keep moving right
                low = mid + 1;
            }
            else if (nums[mid] < target){
                // move right
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        // If nothing is found
        return -1;
    }
}
