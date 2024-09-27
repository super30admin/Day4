// Time Complexity : O(nlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    int first;
    public int[] searchRange(int[] nums, int target) {
        int first=firstBinSearch(nums, target);
        int last=lastBinSearch(nums, target);
        int[] res={first, last};
        return res;
    }
    public int firstBinSearch(int[] nums, int target){
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target && (mid==0 || nums[mid-1]<target)){
                return mid;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
    
    public int lastBinSearch(int[] nums, int target){
        int low=first;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target && (mid==nums.length-1 || nums[mid+1]>target)){
                return mid;
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
}
