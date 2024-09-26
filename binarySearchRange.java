
/*
 *  Time Complexity: O(log n) since we are performing binary search
 *  Space Complexity: Constant as we do not use any extra memory
 * 
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : None
 * 
 *  Similar to binary search we first look for an element in the array, once we find the element then we check if left element is also same i.e, repetative values on left, in that case we perform binary search on the left side of the array to find left most value. To find the rightmost element we modify the condition to check the rigth element is not repeated and peform binary search if its repeating.
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0) return new int[] {-1,-1};
        if(target<nums[0] || target>nums[nums.length-1]) return new int[] {-1,-1};
        int left=-1, right=-1;
        int low = 0, high=nums.length-1;
        left = binarySearchFirst(nums, target);
        if(left==-1) return new int[] {-1,-1};
        right = binarySearchLast(nums, target, left);
        return new int[]{left,right};
    }
    private int binarySearchFirst(int[] nums, int target){
        int low=0, high=nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                if(mid==0 || nums[mid-1]<target) return mid;
                else high = mid-1;
            }
            else if(nums[mid]>target) high=mid-1;
            else if(nums[mid]<target) low = mid+1;
        }
        return -1;
    }
    private int binarySearchLast(int[] nums, int target, int low){
        int high=nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1 || nums[mid+1]>target) return mid;
                else low = mid+1;
            }
            else if(nums[mid]>target) high=mid-1;
            else if(nums[mid]<target) low = mid+1;
        }
        return -1;
    }
    
}
