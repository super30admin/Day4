class Solution {
    public int firstindex(int low, int high, int[] nums, int target){
        low = 0;
        int mid;
        high = nums.length - 1;
        while(low <= high){
          mid = low + (high - low)/2;
          if(nums[mid] == target){
              if(mid == low || nums[mid] > nums[mid - 1]){
                  return mid;
              }
              else{
                  high = mid - 1;
              }
                 }
              else if(nums[mid] > target){
                  high = mid - 1;
              }
              else{
                  low = mid + 1;
              }
    }
        return -1;
    }

    public int lastindex(int low, int high, int[] nums, int target){
        low = 0;
        int mid;
        high = nums.length - 1;
        while(low <= high){
          mid = low + (high - low)/2;
          if(nums[mid] == target){
              if(mid == high || nums[mid] < nums[mid + 1]){
                  return mid;
              }
              else{
                  low = mid + 1;
              }
                 }
              else if(nums[mid] > target){
                  high = mid - 1;
              }
              else{
                  low = mid + 1;
              }

    }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int first = firstindex(0, nums.length - 1, nums, target);
        int last =  lastindex(0, nums.length - 1, nums,target);

        return new int[]{first, last};

    }
}