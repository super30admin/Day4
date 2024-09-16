// Time Complexity : log(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int findMin(int[] nums) {
        int start=0;
        int end=nums.length-1;
        
         if(nums.length==1 || nums[start]<nums[end]) return nums[start];
        while(start<=end){
            int mid=start+(end-start)/2;
           if(start==mid && nums[mid+1]<nums[mid]) return nums[mid+1];
            if(nums[start]>nums[mid]){
                end=mid;
            }else{
                start=mid;
            }
        }
        
        return nums[0];
    }
}