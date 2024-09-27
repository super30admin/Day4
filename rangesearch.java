# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes

class Solution {
     public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1,-1};
        if(nums == null || nums.length == 0) return ans;
        int low = 0;
        int high = nums.length - 1;
        int foundIndex = binarySearch(nums,target,low,high);
        if(foundIndex == -1) return ans;
        int left = binarySearchLeft(nums,target,low,foundIndex);
        int right = binarySearchRight(nums,target,foundIndex,high);
        return new int[]{left,right};
    }
    private int binarySearch(int[]nums, int target,int low,int high){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target) return mid;
            else if(target < nums[mid]) high = mid - 1;
            else low = mid+1;
        }
        return -1;
    }
    private int binarySearchLeft(int[]nums,int target,int low, int high){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
    private int binarySearchRight(int[] nums,int target, int low, int high){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] <= target) low = mid + 1;
            else high = mid - 1;
        }
        return high;
    }
}