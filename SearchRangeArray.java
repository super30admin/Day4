/**
Time complexity: O(log n)
Space complexity: O(1)
Executed on Leetcode? Yes
Any problems faced? No
*/
class SearchRangeArray {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {startingPoint(nums,target), endPoint(nums,target)};
    }
    /**
    Approach:
    - We use 2 functions to find the starting point and ending point.
    - Both the functions will use Binary Search.
    - The starting point function checks if mid has reached the start of the array or element at mid-1 != target to find the starting point.
    - The starting point function checks if mid has reached the end of the array or element at mid+1 != target to find the ending point.
    */
    private int startingPoint(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
            
        while(low <= high) {
            int mid = low + (high-low)/2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid-1] != target) {
                    return mid;
                }
                high = mid-1;
            } else if (nums[mid] < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
        
    private int endPoint(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
            
        while(low <= high) {
            int mid = low + (high-low)/2;
            if (nums[mid] == target) {
                if (mid == nums.length-1 || nums[mid+1] != target) {
                    return mid;
                }
                low = mid+1;
            } else if (nums[mid] < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}

