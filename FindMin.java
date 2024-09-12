// Find Minimum in Rotated Sorted Array

//in leetcode, code executed
import java.util.*;

class FindMin{
  public int findMin(int[] nums){
    int low=0;
    int high=nums.length-1;
    while(low<=high){
      int mid;
      mid=low+(high-low)/2;

      if((mid==0||nums[mid-1]>nums[mid]) && (mid==nums.length-1 || nums[mid+1]>nums[mid])){
        return nums[mid];
      } //other way round not possible for mid in condition because throws error

      // left unsorted->right sorted
      else if(nums[mid]<nums[high]){
        high=mid-1;
      }

      else
      low=mid+1;


    }
    return -1;
  }

}
