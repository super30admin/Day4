// Time Complexity :O log(n)
// Space Complexity :O (1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach

//2nd Approach using 2 stacks
class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int low = 0; int high = nums.length - 1;
        while(low <= high){
            if(nums[low] <= nums[high]) return nums[low]; // already sorted, return low

            int mid = low + (high - low)/2;

            if((mid == 0 || nums[mid -1] > nums[mid]) && (mid == nums.length -1 || nums[mid] < nums[mid + 1])){
                return nums[mid];
            }

            if(nums[low] <= nums[mid]){// means sorted
                low = mid + 1;
            }else{
                high = mid -1;
            }
        }

        return low;
    }
}