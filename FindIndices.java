// Find First and Last Position of Element in Sorted Array
// Time Complexity: O(log N)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

class FindIndices {

    public int[] searchRange(int[] nums, int target) {
        
        int[] result = new int[2];
        int firstIndex = findFirstIndex(nums, target);
        int lastIndex = findLastIndex(nums, target);
        result[0] = firstIndex;
        result[1] = lastIndex;
        
        return result;
    }
    
    public int findFirstIndex(int[] nums, int target) {
        
        int index = -1;
        int left = 0, right = nums.length - 1;
        
        while(left <= right) {
            int mid = left+(right-left)/2;
            if(nums[mid] >= target) {
                right = mid-1;
            }else{
                left = mid+1;
            }
            if(nums[mid] == target) {
                index = mid;
            }   
        }
        return index;
    }
   
    public int findLastIndex(int[] nums, int target) {
        
        int index = -1;
        int left = 0, right = nums.length - 1;

        while(left <= right) {
            int mid = left +  (right - left) / 2;
            
            if(nums[mid] <= target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
            if(nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    } 
}