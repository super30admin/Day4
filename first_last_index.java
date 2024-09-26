// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes


class Solution {
    
    private int binary_search_first(int[] nums, int target){
        int high = nums.length-1;
        int low = 0;  
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] ==target){
                if(mid == 0 || nums[mid] > nums[mid-1]){
                    return mid;
                }
                else{
                    high = mid-1;
                }
            }
            else if(nums[mid] > target){
                high = mid -1;
            }
            else
                low = mid + 1;
        }
        return -1;
    }
    
    private int binary_search_last(int[] nums, int target){
        int high = nums.length-1;
        int low = 0;  
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] ==target){
                if(mid == nums.length-1 || nums[mid] < nums[mid+1]){
                    return mid;
                }
                else{
                    low = mid+1;
                }
            }
            else if(nums[mid] > target){
                high = mid -1;
            }
            else
                low = mid + 1;
        }
        return -1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length ==0)
            return new int[] {-1,-1};
        if(target < nums[0] || target > nums[nums.length-1])
            return new int[] {-1,-1};
        
        int first_index = binary_search_first(nums, target);
        int second_index = binary_search_last(nums, target);
        return new int[] {first_index, second_index};
    }
}