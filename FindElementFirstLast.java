/**
 * Time Complexity - O(logn)
 * Space Complexity - O(1)
 * Yes, this code ran successfully on leetcode
 * This problem is more like finding element in sorted array. Focus on 2 thing - once traverse left and
 * then right only if element is found on left
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {

        int[] ans = new int[]{-1,-1};

        int leftIdx = extremeInsertionIndex(nums,target,false);

        if(leftIdx == nums.length || nums[leftIdx] != target){
            return ans;
        }

        ans[0] = leftIdx;
        ans[1] = extremeInsertionIndex(nums,target,true)-1;

        return ans;

    }

    public int extremeInsertionIndex(int[] nums,int target, boolean left){

        int low = 0, high = nums.length-1;

        while(low <= high){
            int mid = (low+high)>>1;
            if(nums[mid] < target || (left && nums[mid]==target)){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
}