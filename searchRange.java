// Time Complexity: O(log n), n: number of elements in nums array
// Space Complexity: O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[] {-1,-1};
        
        int first = binarySearch(nums, target, false);
        int last = binarySearch(nums, target, true);
        return new int[] {first, last};
    }
    private int binarySearch(int[] nums, int target, boolean last) {
        int low = 0, high = nums.length-1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                if(!last) {
                    if(mid == 0 || nums[mid-1] < nums[mid])
                        return mid;
                    else
                        high = mid - 1;
                }
                else {
                    if(mid == nums.length-1 || nums[mid] < nums[mid+1])
                        return mid;
                    else
                        low = mid + 1;
                }
            }
            else if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}