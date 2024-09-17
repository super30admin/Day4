// Time Complexity : O(logN) - N is size of the array
// Space Complexity : O(1) - No extra data structure is used(Target array is of size 2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Here to have a better time complexity used Binary Search and used a boolean variable  to determine ledt and right position
class Solution {
    public int extremeindex(int[] nums,int target,boolean left){
        int lo = 0;
        int hi = nums.length;
        while(lo < hi){
            int mid = (lo + hi)/2;
            if(nums[mid] > target || left && nums[mid] == target){
                hi = mid;
            }
            else{
                lo = mid + 1;
            }
        }
        return lo;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1,-1};
        for(int i = 0;i < nums.length;i++){
            int leftindex = extremeindex(nums,target,true);
            //if we are unable to find the first position of the element there is no need to check for the last position
            if(leftindex == nums.length || nums[leftindex] != target){
                return targetRange;
            }
            targetRange[0] = leftindex;
            targetRange[1] = extremeindex(nums,target,false) - 1;
        }
        return targetRange;
    }
}
// Your code here along with comments explaining your approach
