//Time Complexity: O(log n + log n) = O(log n)
//Space Complexity: O(1)
//Steps: 1. BS to find right most position
    // a. IF value@mid = target and prev element is not target we got Start position ELSE update high
    // b. If target is < mid, search on left side
    // c. if target is > mid, search on right side
// 2. BS to find left most position similar to above 
// Return values from step 1 & 2


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = startIndex(nums, target);
        if(start != -1)
            return new int[]{start, endIndex(nums, target)};
        else
            return new int[]{-1, -1};
    }
    
    private int startIndex(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(nums[mid] == target){
                if(mid == 0 || nums[mid - 1] != target)
                    return mid;
                else
                    high = mid - 1;
            }
            else if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
    
    private int endIndex(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(nums[mid] == target){
                if(mid == nums.length - 1 || nums[mid + 1] != target)
                    return mid;
                else
                    low = mid + 1;
            }
            else if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}