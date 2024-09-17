// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : -

class SearchFirstAndLastPosition {
    private int binarySearchFirstPosition(int[] nums, int target, int low, int high){
        while(low <= high){
            int mid = low+ (high-low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid] > nums[mid-1])
                    return mid;
                else
                    high = mid -1;
            } else if (nums[mid] < target){
                low = mid + 1;
            } else
                high = mid -1;
        }
        return -1;
    }

    private int binarySearchLastPosition(int[] nums, int target, int low, int high){
        while(low <= high){
            int mid = low+ (high-low)/2;
            if(nums[mid] == target){
                if(mid == nums.length -1 || nums[mid] < nums[mid+1])
                    return mid;
                else
                    low = mid + 1;
            } else if (nums[mid] < target){
                low = mid + 1;
            } else
                high = mid -1;
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1, -1};

        int[] result = new int[2];
        int low = 0;
        int high = nums.length -1;
        result[0] = binarySearchFirstPosition(nums, target, low, high);
        result[1] = binarySearchLastPosition(nums, target, low, high);
        return result;
    }
}