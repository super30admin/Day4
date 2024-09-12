// Find first and Last Position of Element in Sorted Array

// could not proceed with following condition:
// if((mid==nums.length-1 && nums[mid]==target)||(nums[mid+1]>target && nums[mid]==target)){
//   return mid;
// }


import java.util.*;

class PositionSortedArray{
  public int startElement(int[] nums, int target, int low, int high){

    while(low<=high){
      int mid;
      mid=low+(high-low)/2;
      if(nums[mid]==target){
        if((mid==0)||(nums[mid-1]<target)){
          return mid;
        }
        high=mid-1;
      }

      else if(nums[mid]>target){
        high = mid-1;
      }
      else
      low=mid+1;
    }
    return -1;
  }

  public int lastElement(int[] nums, int target, int low, int high){

    while(low<=high){
      int mid;
      mid=low+(high-low)/2;
      if(nums[mid]==target){
        if((mid==nums.length-1)||(nums[mid+1]>target)){
          return mid;
        }
        low=mid+1;
      }

      else if(nums[mid]<target){
        low = mid+1;
      }

      else
      high=mid-1;

    }
    return -1;
  }

  public int[] searchRange(int[] nums, int target){
    int low=0;
    int high=nums.length-1;

    int start=startElement(nums,target,low,high);
    int last=lastElement(nums,target,low,high);

    return new int[]{start,last};
  }
}
