// Time Complexity : O(logn) where n is the number of elements in nums. 
// Space Complexity : O(1).

public class Solution1 {
    //initialized targetLow and targetHigh as -1 in case the target is not found; 
    int targetLow = -1, targetHigh = -1;

    public void binarySearch(int[] nums, int target, int low, int high, boolean direction) {
            while(low<=high) {
            int mid = low + (high - low) / 2;
            //finding the starting position of the target - the value at mid is either less than target or equal to target, if it is equal, move to left to find the lower bound, else move to right. 
            if (direction) {
                if (nums[mid] == target) {
                    targetLow = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            //finding the ending position of the target - the value at mid is either greater than target or equal to target, if it is equal, move to right to find the upper bound, else move to left. 
            else {
                if (nums[mid] == target) {
                    targetHigh = mid;
                    low = mid+1;
                }
                else {
                    high = mid-1;
                }
            }
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            //if the target is found initiating binary search to find the starting and ending position of the target. 
            if(nums[mid] == target) {
                binarySearch(nums, target, low, mid, true);
                binarySearch(nums, target, mid, high, false);
                break;
            }
            else if(nums[mid] > target) {
                high = mid-1;
            }
            else {
                low = mid+1; 
            }
        }
        return new int[]{targetLow, targetHigh}; 
    }
}
