/*
 * Time Complexity: O(log(N)) for binary search approach.
 * Space Complexity: O(1) constant space.
 * */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);

        return res;
    }
    
    private int findFirst(int[] nums, int target) {
        int index = -1;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l)/2;
            int curr = nums[mid];
            if(curr >= target) {
                r = mid -1;
            } else {
                l = mid + 1;
            }
            if (nums[mid] == target) index = mid;
        }
        return index;
    
    }
    private int findLast(int[] nums, int target) {
        int index = -1;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l)/2;
            int curr = nums[mid];
            if(curr <= target) {
                l = mid + 1;
            } else {
                r = mid -1;
            }
            if (nums[mid] == target) index = mid;
        }
        return index;
    }
}