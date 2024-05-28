//time O(2log N) => O(log N) where N is the no of elements in array
//space O(1)
//approach Binary Search

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0 || nums == null) return new int[]{-1, -1};
        if(nums.length == 1 && nums[0] == target) return new int[]{0, 0};
        int n = nums.length;
        int le = binarySearchLeft(nums, 0, n - 1, target);
        int ri = binarySearchRight(nums, 0, n - 1, target);
        return new int[]{le, ri};
        
    }
    
    private int binarySearchLeft(int[] nums, int left, int right, int target) {
        //logic
        int low = left;
        int high = right;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                if(mid == 0 || nums[mid -1] < target) {
                    return mid;
                }
                else {
                    high = mid - 1;
                }
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else if(nums[mid] > target) {
                high = mid - 1;
            }
        }
        return -1;
    }
    
    private int binarySearchRight(int[] nums, int left, int right, int target) {
        //logic
        int low = left;
        int high = right;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                if(mid == high || nums[mid + 1] > target) {
                    return mid;
                } 
                else {
                    low = mid + 1;
                }
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else if(nums[mid] > target) {
                high = mid - 1;
            }
        }
        return -1;
    }
    
    
}
