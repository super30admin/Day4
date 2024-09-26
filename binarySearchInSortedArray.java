// time complexity - O(logn)
//space complexity - O(1)

// Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
// Your algorithm's runtime complexity must be in the order of O(log n)
// If the target is not found in the array, return [-1, -1].

// Example 1:
// Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4] Example 2:
// Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1]






class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1,-1};
        //finding the left index target
        int leftidx = method(nums,target,true);
        
        //if leftidx not found 
        if(leftidx == nums.length || nums[leftidx] != target){
            return targetRange;
        }
        // targetRange[0] = left index
            targetRange[0] = leftidx;
        
        //targetRange[1] = right index
            targetRange[1] = method(nums,target,false) -1;
            return targetRange;
    }
    
    public int method(int[] nums, int target, boolean left){
        int lo = 0;
        int hi = nums.length;
        //simple binary search
        while(lo<hi){
            int mid = (lo+hi)/2;
            if(nums[mid] > target || (left && target == nums[mid]))
            {
                hi =mid;
            }
            else {
                lo = mid+1;
            }
        }
        return lo;
    } 
}