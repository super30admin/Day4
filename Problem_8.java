class Solution {

    /*
     * Time Complexity - O(logn)
     * Space Complexity - O(1)
     */
    public int[] searchRange(int[] nums, int target) {
         if (nums == null || nums.length == 0) return new int[] {-1, -1};
        int first = findLeftMostIndex(nums, target);
        if (first == -1) return new int[] {-1, -1};
        int last = findRightMostIndex(nums, target, first);
        return new int[] {first, last};
    }
    
    private int findRightMostIndex(int[] nums, int target, int left) {
        int low = left, high = nums.length-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (nums[mid] > target) 
                high = mid-1;
            else if (nums[mid] < target)
                low = mid+1;
            else {
                // If nums[mid] == target, if right element is different from mid, we found
                // rightmost element.
                if (mid == nums.length-1 || nums[mid+1] > nums[mid]) 
                    return mid;
                else 
                    // otherwise search in second half 
                    low = mid+1;
            }
        }
        return -1;
    }
    
    private int findLeftMostIndex(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (nums[mid] > target) 
                high = mid-1;
            else if (nums[mid] < target)
                low = mid+1;
            else {
                // If nums[mid] == target, if left element is different from mid, we found
                // leftmost element. 
                if (mid==0 || nums[mid-1] < nums[mid]) {
                    return mid;
                }
                else {
                    // otherwise search in first half 
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}