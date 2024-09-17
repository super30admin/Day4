/** Time Complexity: O(logN)
 ** Space Complexity: O(1)
 **/ 
class Solution {
    private int leftBinarySearch(int[] nums, int target){            // Binary Search to find First occurence
        int low = 0; int high = nums.length - 1; int mid; int res = -1;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(nums[mid] > target){
                high = mid - 1;
            } else if(nums[mid] < target){
                low = mid + 1;
            } else{
                res = mid;
                high = mid - 1;
            }
        }
        return res;
    }
    
    private int rightBinarySearch(int[] nums, int target){            // Binary Search to find Second occurence
        int low = 0; int high = nums.length - 1; int mid; int res = -1;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(nums[mid] > target){
                high = mid - 1;
            } else if(nums[mid] < target){
                low = mid + 1;
            } else{
                res = mid;
                low = mid + 1;
            }
        }
        return res;
    }
    
    public int[] searchRange(int[] nums, int target) {
        
        int[] result = new int[2];
        
        
        int left = leftBinarySearch(nums, target);
        if(left == -1) return new int[]{-1, -1};            // Return (-1,-1) if first occurence not found
        int right = rightBinarySearch(nums, target);
        
        return new int[]{left,right};
        
    }
}