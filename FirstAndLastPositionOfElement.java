/*
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 * Any problem faced while coding this:
 * */

class FirstAndLastPositionOfElement {
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int[] res = {-1, -1};
        if(nums.length == 0){
            return res;
        }
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        if(nums[low] == target) {
            res[0] = low;
        } else {
            return res;
        }

        high = nums.length - 1;
        while(low < high) {
            int mid = (low + (high - low) / 2) + 1;
            if(target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }

        res[1] = low;
        return res;
    }
}