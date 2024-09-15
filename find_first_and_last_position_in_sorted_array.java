// Time Complexity : O(login)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;

        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] < target) low = mid + 1;
            else if(nums[mid] > target) high = mid - 1;
            else {
                low = high = mid;
                while(low > 0 && nums[low - 1] == target) low--;
                while(high < n - 1 && nums[high + 1] == target) high++;
                return new int[] {low, high};}
        } return new int[] {-1, -1};
    }
}
