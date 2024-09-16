
//Binary Search
//Time Complexity - O(Log N)
//Space Complexity - O(1)

class Solution {
  public int findMin(int[] nums) {

    int low = 0, high = nums.length-1;

    while(low < high){

      if(nums[low] < nums[high]) { return nums[low]; }

      int mid = low + (high-low)/2;

      if(mid-1 >= 0 && nums[mid-1] > nums[mid]){
        return nums[mid];
      }

      if(nums[mid] < nums[high]){
        high = mid-1;
      }else{
        low = mid+1;
      }
    }

    return nums[low];
  }
}