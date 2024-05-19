// Time Complexity : O(logn)
// Space Complexity : O(1)

// The code uses binary search to find the first and last indices of a target in a sorted array `nums`.
// It includes methods `first` and `second` for locating the leftmost and rightmost occurrences of the target.
// The `searchRange` method returns these indices in an array, optimizing search efficiency to logarithmic time complexity relative to `nums` size.

class Solution {
    public int[] searchRange(int[] nums, int target) {
       int left = first(nums, 0, nums.length -1, target);
       int right = second(nums, 0, nums.length -1, target);
       return new int[] {left,right}; 
    }

    public int first(int[] nums,int low, int high, int target){
        while(low <= high){
            int mid = low +(high-low)/2;
            if(nums[mid] == target){
                if((mid == 0 || nums[mid-1] < target)){
                    return mid;
                }else{
                   high = mid-1;
                }
            }else if(nums[mid] > target){
               high = mid-1; 
            }else{
                low = mid+1;
            }
        }
        return -1;
    }

    public int second(int[] nums,int low, int high, int target){
        while(low <= high){
            int mid = low +(high-low)/2;
            if(nums[mid] == target){
                if((mid == nums.length-1 || nums[mid+1] > target)){
                    return mid;
                }else{
                   low = mid+1;
                }
            }else if(nums[mid] > target){
               high = mid-1; 
            }else{
                low = mid+1;
            }
        }
        return -1;
    }    
}