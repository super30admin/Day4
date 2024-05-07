// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// Any problem you faced while coding this : No


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = firstOccurence(nums,target);
        int right = lastOccurence(nums,target);
        return new int[] {left, right};

    }

    public static int firstOccurence(int[]nums, int k){
        int left =0, right = nums.length-1;
        int first = -1;

        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==k){
                first = mid;
                right = mid-1;
            }else if(nums[mid]<k){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
       return first;
    }

    public static int lastOccurence(int[]nums, int k){
        int left =0, right = nums.length-1;
        int last = -1;

        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==k){
                last = mid;
                left = mid+1;
            }else if(nums[mid]>k){
                right =mid-1;
            }else{
                left = mid+1;
            }
        }
       return last;
    }
}
