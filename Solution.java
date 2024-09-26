/*
Time -O(logn)
Space - O(1)
find the min element using binary search and then move the two pointers to left and right untill you find
the same element


*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0){
            return new int[]{-1,-1};
        }
        if(nums.length ==1 && nums[0] == target){
            return new int[]{0,0};
        }
        int low=0;
        int high=nums.length-1;
        int mid=0;
        while(low<=high){
            mid = low +(high-low)/2;
            if(nums[mid] == target)  break;
            if(nums[mid]<target){
                low = mid+1;}
            else{
                 high = mid-1;
               } 
            }
      if(nums[mid] != target){
          return new int[]{-1, -1};
      }
    
        int i=mid;
        while(i!=0 && nums[i] == nums[i-1]){
            i--;
        }
        int j=mid;
        while( j!=nums.length-1 && nums[j] == nums[j+1]){
            j++;
        }
        return new int[]{i,j};
    }
}