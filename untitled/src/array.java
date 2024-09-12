class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res= {-1,-1};
        if(nums == null || nums.length == 0) {
            return res;
        }

        if(target < nums[0] || target > nums[nums.length-1]) {
            return res;
        }

        res[0] = binarySearchFirst(nums, target);
        res[1] = binarySearchLast(nums, target);
        return res;
    }

    private int binarySearchFirst(int[] nums, int target) {
        int left = 0, right = nums.length-1;

        while(left <= right) {
            int mid = left + (right-left)/2;

            if(nums[mid] == target) {
                if(mid == 0 || nums[mid] > nums[mid-1]) {
                    return mid;
                }
                else {
                    right = mid-1;
                }
            }
            else if(nums[mid] > target) {
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
        return -1;
    }

    private int binarySearchLast(int[] nums, int target) {
        int left = 0, right = nums.length-1;

        while(left <= right) {
            int mid = left + (right-left)/2;

            if(nums[mid] == target) {
                if(mid == nums.length-1 || nums[mid] < nums[mid+1]) {
                    return mid;
                }
                else {
                    left = mid+1;
                }
            }
            else if(nums[mid] > target) {
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
        return -1;
    }
}