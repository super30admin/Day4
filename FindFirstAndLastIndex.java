//Time Complexity: log n
//Space Complexity: O(1)
public class FindFirstAndLastIndex {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        return new int[] {firstIndex(nums,target),lastIndex(nums,target)};

    }
    public int firstIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                if(mid == 0 || nums[mid] != nums[mid -1]) {
                    return mid;
                }
                else {
                    high = mid - 1;
                }
            }
            else if(nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public int lastIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                if(mid == nums.length-1 || nums[mid] != nums[mid + 1]) {
                    return mid;
                }
                else {
                    low = mid + 1;
                }
            }
            else if(nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
