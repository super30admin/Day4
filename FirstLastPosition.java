// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class FirstLastPosition {
    public int[] searchRange(int[] nums, int target) {

        if(nums.length == 0 || nums == null){
            return new int[]{-1,-1};
        }

        if(target < nums[0] || nums[nums.length - 1] < target){
            return new int[]{-1,-1}; // Optimization for edge case
        }

        int startIndex = -1;
        int lastIndex = -1;

        startIndex = firstBinarySearch(nums, target);
        if(startIndex == -1){
            return new int[]{-1, -1};
        }

        lastIndex = secondBinarySearch(nums, target);

        return new int[]{startIndex, lastIndex};
    }

    public int firstBinarySearch(int[] nums, int target){

        int low = 0;
        int high = nums.length - 1;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                if(mid == 0 || nums[mid - 1] < nums[mid]){
                    return mid;
                }else{
                    high = mid -1; /////// Not the first index so search left part of the array
                }
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return -1;
    }

    public int secondBinarySearch(int[] nums, int target){

        int low = 0;
        int high = nums.length - 1;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                if(mid == nums.length - 1 || nums[mid + 1] > nums[mid]){
                    return mid;
                }else{
                    low = mid + 1; /////// Not the first index so search left part of the array
                }
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return -1;
    }
}
