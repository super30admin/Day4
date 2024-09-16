//Binary Search
//Time Complexity - O(log N)
//Space complexity - O(1) - only result int[] of size 2 is created
class Solution {
  public int[] searchRange(int[] nums, int target) {

    int start = findFirstPosition(nums, target);
    if(start == -1) { return new int[]{-1,-1}; }
    int end = findLastPosition(nums, target);

    return new int[]{start,end};
  }

  public int findFirstPosition(int[] nums, int target){
    int low = 0, high = nums.length-1;
    int result = -1;

    while(low <= high){

      int mid = low+ (high-low)/2;

      if(nums[mid] == target){
        result =  mid;
      }
      if(nums[mid] >= target ){
        high = mid-1;
      }else{
        low = mid+1;
      }

    }
    return result;
  }

  public int findLastPosition(int[] nums, int target){
    int low = 0, high = nums.length-1;
    int result = -1;

    while(low <= high){

      int mid = low+ (high-low)/2;

      if(nums[mid] == target){
        result = mid;
      }
      if(target >= nums[mid]){
        low = mid+1;
      }else{
        high = mid-1;
      }

    }
    return result;
  }
}