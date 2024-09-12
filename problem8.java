// Time Complexity :O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int [] {Binary_Search_First(nums,target),Binary_Search_Last(nums,target)};       
          
    }

    public int Binary_Search_First(int[]nums,int target){
        int low=0;
        int high = nums.length-1;
        int first = -1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                first = mid;
                high = mid -1;
            }else if(nums[mid] < target){
                low = mid+1;
            }else{
                high = mid -1;
            }
        }
        return first;

    }
    public int Binary_Search_Last(int[]nums,int target){
        int low=0;
        int high = nums.length-1;
        int last = -1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                last = mid;
                low = mid + 1;            
            }else if(nums[mid]<target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return last;
    }
}