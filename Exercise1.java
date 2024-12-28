//34. Find First and Last Position of Element in Sorted Array



class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null && nums.length == 0) {
            return new int[] { -1, -1 };
        }
        int first = findPositionFirst(nums, target);
        if (first == -1) {
            return new int[] { -1, -1 };
        }
        int second = findPositionLast(nums, target, first);
        return new int[] { first, second };

    }

    private int findPositionFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == low || nums[mid - 1] != nums[mid]) {
                    return mid;
                } else {
                    
                    high = mid - 1;
                }
            }else if ( nums[mid] < target) {
                low = mid +1;
            }else {
                high = mid -1;
            }
        }
        return -1;
    }

    private int findPositionLast(int[] nums, int target, int first) {
        int low = first;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == high || nums[mid + 1] != nums[mid]) {
                    return mid;
                } else {
                    low = mid+1;
                }
            }else if ( nums[mid] < target) {
                low = mid +1;
            }else {
                high = mid -1;
            }
        }
        return -1;
    }
}