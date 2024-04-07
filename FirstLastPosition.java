// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Iterate the array using binary search two times to find first and last index in the array
class FirstLastPosition {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1,-1};
        if(target < nums[0] && target > nums[nums.length-1]) return new int[]{-1,-1};
        
        
        int firstIndex = binarySearchFirst(nums, target);
        int secondIndex = binarySearchSecond(nums, target);
        return new int[]{firstIndex, secondIndex};
    }
        private int binarySearchFirst(int[] nums, int target) {
            int low = 0, high = nums.length - 1;
            while(low <= high) {
                int mid = low+(high - low)/2;
                if(nums[mid] == target) {
                    if(mid == low || nums[mid-1] != target) {
                        return mid;
                    } else {
                        high = mid - 1;
                    }
                }else if(nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid +  1;
                }
        }
        return -1;
        }
        private int binarySearchSecond(int[] nums, int target) {
            int low = 0, high = nums.length - 1;
            while(low <= high) {
                int mid = low+(high - low)/2;
                if(nums[mid] == target) {
                    if(mid == high || nums[mid+1] != target) {
                        return mid;
                    } else {
                        low = mid + 1;
                    }
                }else if(nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid +  1;
                }
        }
        return -1;
    }
}