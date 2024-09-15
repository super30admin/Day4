// Time Complexity :O(log N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1, -1};

        int left = binarySearchFirst(nums,target);
        int right = binarySearchLast(nums,target);
        return new int[]{left,right};
    }

    private int binarySearchFirst(int[]nums,int target){
        int low = 0,high =nums.length -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1] < nums[mid]){
                    return mid;
                }else{
                    high = mid -1;
                }
            }
            else if(target <nums[mid]){
                high = mid-1;
            }
            else{
                low = mid +1;
            }
        }
        return -1 ;
    }

    private int binarySearchLast(int[]nums,int target){
        int low = 0,high = nums.length -1;
        while(low <= high){
            int mid = low + (high -low)/2;
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid+1]>nums[mid]){
                    return mid;
                }
                else{
                    low = mid + 1;
                }
            }
            else if(target <nums[mid]){
                high = mid-1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
}