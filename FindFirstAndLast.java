// Time Complexity : o(log(n) + o(log(n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    int lowForlast;
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        if(null == nums || nums.length == 0) return result;
        if(nums[0] > target || nums[nums.length -1] < target) return result;
        
        int low = 0;
        int high = nums.length - 1;
        
        int first = findFirst(nums, target);
        if(first == -1) return result;
        lowForlast = first;
        
        int last = findLast(nums,target);
        return new int[] {first, last};
        
    }
    
    private int findFirst(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid] > nums[mid -1]){
                    return mid;
                } else{
                    high = mid - 1;
                }
            } else if(nums[mid] > target){
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        return -1;
    }
    
    private int findLast(int[] nums, int target){
        int low = lowForlast;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid] < nums[mid + 1]){
                    return mid;
                } else{
                    low = mid + 1;
                }
            } else if(nums[mid] > target){
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        return -1;
    }
}