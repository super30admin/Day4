// Time Complexity: O(log n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach: Binary Search - Find the first occurrence of the target element and then find the last occurrence of the target element.

class Problem1 {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }

        int n = nums.length;

        int firstIndex = binarySearchFirst(nums, 0, n-1, target);
        // No need to go further
        if(firstIndex == -1){
            return new int[]{-1, -1};
        }
        int secIndex = binarySearchLast(nums, firstIndex, n-1, target);

        return new int[]{firstIndex, secIndex};
    }

    private int binarySearchFirst(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target){
                if(mid == 0 || nums[mid] != nums[mid-1]){
                    return mid;
                }else{
                    high = mid-1;
                }
            }else if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }

    private int binarySearchLast(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid] != nums[mid+1]){
                    return mid;
                }else{
                    low = mid+1;
                }
            }else if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
}