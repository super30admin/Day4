// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class FirstLastArraySolution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        //Since array is sorted do binary search to get index of the first position
        int getFirstPosition = firstPosition(nums, target);

        //If element is not present no required to do binary search on last posotion
        if (getFirstPosition == -1) {
            return new int[]{-1, -1};
        }

        //Since array is sorted do binary search to get index of the last position
        int getLastPosition = lastPosition(nums, target);

        return new int[]{getFirstPosition, getLastPosition};
    }

    public int firstPosition(int arr[], int target) {
        int low = 0; 
        int high = arr.length - 1; 
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > target) {
                high = mid - 1;
            }
            else if (arr[mid] < target) {
                low = mid + 1;
            }
            else {
                index = mid;
                high = mid - 1;
            }
        }
        return index;
    }

    public int lastPosition(int arr[], int target) {
        int low = 0; 
        int high = arr.length - 1; 
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > target) {
                high = mid - 1;
            }
            else if (arr[mid] < target) {
                low = mid + 1;
            }
            else {
                index = mid;
                low = mid + 1;
            }
        }
        return index;
    }
}
