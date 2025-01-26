// Time Complexity : O(2log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Using binary search find the value of starting index of target.
 * Use binary search again on first index of target(because last index will always be after first index of target) to n-1, to find the last index of target.
 * return them in array form.
 *
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        if(n==0){
            return new int[]{-1,-1};
        }
        if(target>nums[n-1] || target<nums[0]){
            return new int[]{-1,-1};
        }
        int left=binarySearchFirst(nums,0,n-1,target);
        if(left==-1){
            return new int[]{-1,-1};
        }
        int right=binarySearchLast(nums,left,n-1,target);
        return new int[]{left,right};
    }

    private int binarySearchFirst(int[] nums,int left,int right,int target){
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target && (mid==left || nums[mid]>nums[mid-1])){
                return mid;
            }else if(nums[mid]>=target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }

    private int binarySearchLast(int[] nums,int left,int right,int target){
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target && (mid==right || nums[mid]<nums[mid+1])){
                return mid;
            }else if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }
}