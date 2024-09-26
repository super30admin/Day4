// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int findMin(int[] nums) {
        if(nums==null || nums.length==1) return nums[0];
        int l=0, h= nums.length-1;
      
        while(l<=h){
            //if first elememt is less than the last element means the array is not rotated and first element is min
            if(nums[l]<=nums[h]){
                return nums[l];
            }
            int mid= l+(h-l)/2;
            //if left and right elements of mid are larger means that this is the min element
            if((mid==0 || nums[mid-1] > nums[mid]) && (mid==(nums.length-1) || nums[mid] < nums[mid+1])){
                return nums[mid];
            }
            //if the mid element is larger than left element check min in first half of array
            else if(nums[mid]>=nums[l]){
                l=mid+1;   
            }else{
                //else check in second half of array
                h=mid-1;
            }
        }
        return 121231;
    }
}