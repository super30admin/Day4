// Time Complexity : o(log n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

class Solution {
    
    public static int firstOcu(int[] nums, int tar) {
        int low = 0;
        int high = nums.length-1;
        int ans = -1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == tar) {
                high = mid-1;
                ans = mid;
                if(mid > 0 && nums[mid-1] != tar) return mid;
            } else if(nums[mid] > tar) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return ans;
    }
    
    public static int secondOcu(int[] nums, int tar) {
        int low = 0;
        int high = nums.length-1;
        int ans = -1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == tar) {
                low = mid+1;
                ans = mid;
                if(mid+1 < nums.length && nums[mid+1] != tar) return mid;
            } else if(nums[mid] > tar) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return ans;
    }
    
    public int[] searchRange(int[] nums, int tar) {
        if(nums.length == 0) {
            return new int[] {-1, -1};
        }
        if(tar < nums[0] || tar>nums[nums.length-1]) {
            return new int[] {-1, -1};
        }
        
        int firstOc = firstOcu(nums, tar);
        if(firstOc == -1) {
            return new int[] {-1, -1};
        }
        int secondOc = secondOcu(nums, tar);
        
        return new int[] {firstOc, secondOc};
    }
}