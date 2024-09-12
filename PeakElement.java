// Find the peak element in the array

// leetcode ran
// difficulty: in leetcode time exceeded and few small syntax error like missing
// the return statement

import java.util.*;

class PeakElement{
  public int findPeakElement(int[] nums){
    int low = 0;
    int high=nums.length-1;

    while(low<=high){
      int mid;
      mid=low+(high-low)/2;

      if((mid==0||nums[mid-1]<nums[mid]) && (mid==nums.length-1 || nums[mid+1]<nums[mid]))
      {
        return mid;
      }
      else if(nums[mid]<nums[mid+1]){
        low=mid+1;
      }

      else{             //if this as else if condition then include mid>0 to avoid underflow
        high=mid-1;
      }
    }
    return -1;
  }
}
