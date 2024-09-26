// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class FindFirstAndLastElement {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1, -1};
        if (target > nums[nums.length - 1] || target < nums[0]) return new int[]{-1, -1};
        
        int low = 0;
        int high = nums.length - 1;
        
        int first = binarySearchFirst(nums, low, high, target);
        if(first == -1) return new int[]{-1, -1};
        int last = binarySearchLast(nums, low, high, target);
        return new int[]{ first, last };
    }
    
    public int binarySearchFirst(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid - 1] < nums[mid]){
                    return mid;
                }
                else{
                    high = mid - 1;
                }
            }
            else if(nums[mid]>target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
    
    public int binarySearchLast(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid + 1] > nums[mid]){
                    return mid;
                }
                else{
                    low = mid + 1;
                }
            }
            else if(nums[mid]>target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
}