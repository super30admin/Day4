class Solution {
    // Time complexity: O(logn)
    // Space Complexity :O(1)  
    public int[] searchRange(int[] nums, int target) {
        int first = binarySearchFirst(nums, target);
        if(first == -1){
            return new int[]{-1, -1};
        }
        int second = binarySearchSecond(nums, target);
        return new int[]{first, second};
    }

    private int binarySearchFirst(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid =  low + (high - low) / 2;
            if(nums[mid] == target){
                if(mid == low || nums[mid - 1] < nums[mid]){
                    return mid;
                } else {
                    high = mid - 1;
                }

            } else if(nums[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private int binarySearchSecond(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid =  low + (high - low) / 2;
            if(nums[mid] == target){
                if(mid == high || nums[mid + 1] > nums[mid]){
                    return mid;
                } else {
                    low = mid + 1;
                }

            } else if(nums[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}