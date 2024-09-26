class Solution {
  public int findMin(int[] nums) {
    if(nums.length < 2)
      return nums[0];
    else
      return findMisplacedPivot(nums, 0,nums.length-1);
  }

  private int findMisplacedPivot(int[] nums,int low, int high){
    int min = 0;
    while(low<high){
      int partition = (low + high)/2;
      min = nums[partition];
      if(nums[partition] > nums[high]){
        low = partition+1;
        min = nums[high];
      }
      else if(nums[low] <  nums[partition]){
        high = partition-1;
        min = nums[low];
      }
      else{
        low = low + 1;
        high = high - 1;
      }

    }
    return min;
  }
}
