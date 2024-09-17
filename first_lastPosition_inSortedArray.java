class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return new int[] {-1,-1};
        }
        if(target < nums[0] || target > nums[nums.length - 1]) {
            return new int[] {-1,-1};
        }
        int first = binarySearchFirst(nums, target);
        if(first == -1) {
            return new int[] {-1,-1};
        }
        int second = binarySearchSecond(nums, target);
        return new int[] {first, second};
    }
    private int binarySearchFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;     
            if(nums[mid] == target) { //if found either there are same elemets to its left or its the last element that's same
                if(mid == 0 || nums[mid - 1] < nums[mid]) {
                    return mid;
                }
                else {
                    high = mid - 1;
                }
            }
            else if(target < nums[mid]) { // usual binary search conditon
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
    private int binarySearchSecond(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) { // if found either there are same elements to the right or its the last element. if first condition of OR is true it wont check the another operand
                if(mid == nums.length - 1 || nums[mid] < nums[mid + 1]) {
                    return mid;
                }
                else {
                    low = mid + 1;
                }
            }
            else if(target < nums[mid]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return - 1;
    }
}