// Time Complexity : log n
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {

    private int binarySearchLeft(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                if(mid == 0 || nums[mid]>nums[mid-1]) return mid;
                else high = mid - 1;
            }else if(nums[mid]> target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    private int binarySearchRight(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                if(mid == nums.length - 1 || nums[mid]<nums[mid+1]) return mid;
                else low = mid + 1;
            }else if (nums[mid]> target) high = mid - 1;
            else low = mid+1;
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[] {-1,-1};
        int n = nums.length;
        int left = binarySearchLeft(nums, 0, n-1, target);
        if(left == -1) return new int[] {-1,-1};
        int right = binarySearchRight(nums, left, n-1, target);
        return new int[] {left,right};
    }
}