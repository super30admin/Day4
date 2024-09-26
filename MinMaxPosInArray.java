class Solution {
  public int[] searchRange(int[] nums, int target) {
    int first =  firstOccurance(nums,0, nums.length-1, target);
    int second = secondOccurance(nums,0, nums.length-1,target);
    int[] result = {first,second};
    return result;
  }
  private int firstOccurance(int[] nums,int low, int high,int target){
    if(low<=high){
      int mid = (low + high)/2;
      if((mid == 0 || target > nums[mid-1]) && nums[mid] == target)
        return mid;
      else if(nums[mid] < target)
        return firstOccurance(nums,mid+1,high,target);
      else if(nums[mid] > target)
        return firstOccurance(nums,low,mid-1,target);
      else
        return firstOccurance(nums,low,mid-1,target);
    }
    return -1;
  }

  private int secondOccurance(int[] nums,int low, int high,int target){
    if(low<=high){
      int mid = (low + high)/2;
      if((mid == nums.length-1 || target < nums[mid+1]) && nums[mid] == target)
        return mid;
      else if(nums[mid] < target)
        return secondOccurance(nums,mid+1,high,target);
      else if(nums[mid] > target)
        return secondOccurance(nums,low,mid-1,target);
      else
        return secondOccurance(nums,mid+1,high,target);
    }
    return -1;
  }
}