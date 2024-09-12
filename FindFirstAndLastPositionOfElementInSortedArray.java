
// Time Complexity : O(logN) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1,-1};

        int firstElement = binarySearch(nums, target, true);

        if(firstElement == -1) return new int[]{-1,-1};

        int secondElement = binarySearch(nums, target, false);


        return new int[]{firstElement,secondElement};
    }

    private int binarySearch(int[] nums, int target, boolean isFirstElemenSearch) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) /2;
            if(nums[mid] > target) {
                high = mid - 1;
            } else if(nums[mid] < target) {
                low = mid + 1;
            }else {
                if(isFirstElemenSearch) {
                    if(mid == low || nums[mid -1]!= target)
                        return mid;
                    high = mid-1;
                } else {
                    if(mid == high || nums[mid +1]!= target)
                        return mid;
                    low = mid+1;
                }

            }
        }
        return -1;
    }
}