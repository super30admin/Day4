// 34. Find First and Last Position of Element in Sorted Array

class Solution {
    
    private int bsFirst( int [] nums, int target){
        int low = 0; int high = nums.length -1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid] > nums[mid-1])
                    return mid;
                else high = mid -1; // keep moving left
            } else if (nums[mid] > target ) {
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
        return -1;
    }

    private int bsLast( int [] nums, int target){
        int low = 0; int high = nums.length -1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == nums.length -1 || nums[mid] < nums[mid+1])
                    return mid;
                else low = mid +1; // keep moving right
            } else if (nums[mid] < target ) {
                low = mid +1;
            } else {
                high = mid -1;
            }
        }
        return -1;
    }
    
    
    
    
    public int[] searchRange(int[] nums, int target) {
        
        if(nums == null || nums.length == 0) {
            return new int [] {-1,-1};
        }
        if(target < nums[0] || target > nums[nums.length-1]) return new int [] {-1,-1};
        int first = bsFirst (nums, target);
        int last = bsLast (nums, target);
        return new int [] {first, last};
    }
}

    
// Time Complexity: O(logN) - considering there are N elements in the array. 
// space Complexity: O(1) since we only use space for a few variables and our result array, all of which require constant space.