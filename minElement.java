// Time Complexity : O(log(n))
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//simple binary search
// Your code here along with comments explaining your approach

class Solution {
    public int findMin(int[] nums) {
        int h =nums.length-1;
        int l = 0;
        if (nums.length == 1){
            return nums[0];
        }
        if (nums[h] > nums[0]) {
      return nums[0];
    }
        while(l <= h){
            int mid = l + ( h - l)/2;
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }
            if (nums[mid -1] > nums[mid]){
                return nums[mid];
            }
            
            if (nums[mid] > nums[0]){
                l = mid + 1;
            }
            else{
                h = mid -1;
            }
                
        
            }
        return -1;
        }
        
}