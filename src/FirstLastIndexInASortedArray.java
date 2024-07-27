//Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
// Time complexity: O(log n)
public class FirstLastIndexInASortedArray {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int lastIndex;
        int firstIndex = binarySearchFirst(nums, target, low,high);
        if(firstIndex == -1) return new int[] {-1,-1};
        else lastIndex = binarySearchLast(nums, target, firstIndex, high);
        return new int[] {firstIndex,lastIndex};
    }
    public int binarySearchFirst(int[] nums, int target,int low, int high) {
        while (low<=high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                if(mid ==0 || nums[mid] > nums[mid-1])
                    return mid;
                high = mid-1;
            }
            else if(nums[mid] > target) {
                high = mid -1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }

    public int binarySearchLast(int[] nums, int target,int low, int high) {
        while (low<=high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                if(mid == nums.length-1 || nums[mid] < nums[mid+1])
                    return mid;
                low = mid + 1;
            }
            else if(nums[mid] > target) {
                high = mid -1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
}
