class Solution {
//tc:O(logn), sc: O(1)
    public int findPeakElement(int[] nums) {
        int first=0;
        int last=nums.length-1;
        while(first<=last){
            int mid=first+(last-first)/2;
           //mid should be greater than its left and right,mid-1 becomes -1 or mid+1 becomes last+1, so keep them in first check,if first is mid or last is mid
           if((mid==0 || nums[mid]>=nums[mid-1]) && (mid==last||nums[mid+1]<=nums[mid]))
               return mid;
            else if(nums[mid]<nums[mid+1])first=mid+1;
            else last=mid-1;
              }
              return 0;
}}
