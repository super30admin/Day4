// Time Complexity : O(log n) for finding the first occurrence and O(log n)
// to find the last = O(log n) + O(log n) = O(log n)
// Space Complexity : O(1) in addition to the array provided
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : struggled a bit with the edge cases

class FirstAndLast {
    public int[] searchRange(int[] nums, int target) {
        int left = binarySearchLeft(nums, 0, nums.length - 1, target);
        int right = binarySearchRight(nums, 0, nums.length - 1, target);
        
        if(left > right) {
            left = right = -1;
        }
        return new int[]{left, right};
    }
    
    public int binarySearchLeft(int[] nums, int left, int right, int target) {
        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left > -1 ? left : -1;
    }
    
    public int binarySearchRight(int[] nums, int left, int right, int target) {
        while(left<=right) {
            int mid = left + (right - left) / 2;
            
            if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right > -1 ? right : -1;
    }
}