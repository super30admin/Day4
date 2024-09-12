Time Complexity: O(log n)
Space Complexity: O(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = binarySearch(nums, target, false);
        int last = binarySearch(nums, target, true);
        return new int[]{first, last};
    }
    
    private int binarySearch(int[] nums, int target, boolean last) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                //search for first
                if(!last) {
                    if(mid == 0 || nums[mid] > nums[mid-1]) {
                        return mid;
                    }else {
                        high = mid - 1;
                    }
                }else {
                    if(mid == nums.length - 1 || nums[mid] < nums[mid+1]) {
                        return mid;
                    }else {
                        low = mid + 1;
                    }
                }
                
                //search for last
                
            }else if(nums[mid] > target) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }
}