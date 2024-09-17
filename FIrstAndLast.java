class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1,-1};
        int low = 0, high = nums.length-1;
        int res[] = new int[2];
        res[0] = binarySearch(nums, target, true);
        res[1] = binarySearch(nums, target, false);
        return res;
    }
    
    int binarySearch(int[] nums, int target, boolean first) {
        int low = 0, high = nums.length -1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (target == nums[mid]) {
                if (first) {
                    if (mid == 0 || nums[mid-1] < target) {
                        return mid;
                    } else {
                        high = mid - 1;
                    }
                } else {
                    if (mid == nums.length - 1 || nums[mid+1] > target) {
                        return mid;
                    } else {
                        low = mid + 1;
                    }
                }
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return -1;
    }
}