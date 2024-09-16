// Time Complexity: O(log n)
// SPace Complexity: O(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {
      int[] res = new int[2];
      int l=0;
      int h = nums.length-1;
      int start=-1; int end = -1;
      if(nums.length == 1){
        return nums[0] == target ? new int[]{0,0} : new int[]{-1,-1};
      }
      
      
      start = start(nums,target);
      end = end(nums,target);
      
      return new int[]{start,end};
        
    }
  
    public int start(int[] nums,int target){
      int l= 0;
      int h = nums.length - 1;
      
      while(l<=h){
        int mid = l + (h-l)/2;
        if(target == nums[mid]){
          if(mid == 0 || nums[mid-1] != target){
            return mid;
          }
          h = mid - 1;
        }else if(nums[mid] < target ){
          l = mid + 1;
        }
        else{
          h = mid - 1;
        }
      }
      return -1;
    }
  
    public int end(int[] nums,int target){
      int l= 0;
      int h = nums.length - 1;
      
      while(l<=h){
        int mid = l + (h-l)/2;
        if(target == nums[mid]){
          if(mid == nums.length-1 || nums[mid+1] != target){
            return mid;
            
          }
          l = mid + 1;
        }else if(nums[mid] < target ){
          l = mid + 1;
        }
        else{
          h = mid - 1;
        }
      }
      return -1;
    }
}
