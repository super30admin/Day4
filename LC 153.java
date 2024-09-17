
// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int findMin(int[] nums) {
        if(nums[0] < nums[nums.length-1]){
            return nums[0];
        }
        if(nums.length == 1){
          return nums[0];  
        }
        int start = 0;
        int end = nums.length-1;
        while (start <= end){
            int mid = (start+end)/2;
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[mid-1] > nums[mid]){
                return nums[mid];
            }
            if(nums[0] < nums[mid]){
                start = mid+1;
            }else{
                end = mid -1;
            }
        }
        return -1;
    }
}
