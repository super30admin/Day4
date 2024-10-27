// Time Complexity : logn + log n = O(logn)
// Space Complexity : O(1)
// Approach : Using Binary Search calculate first index of target which elements second half of arrya and using another binary search calculate second index which eliminates first half of array.
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n =nums.length;
        if(n==0) return new int []{-1,-1};
        int low = 0;
        int high = nums.length -1;

        int firstPosition = firstBinarySearch(nums,low,high,target);
        if (firstPosition == -1){
            return new int[]{-1,-1};
        }

        int lastPosition = secondBinarySearch(nums,firstPosition,high,target);
        return new int []{firstPosition,lastPosition};
    }
    public int firstBinarySearch(int[] nums , int low, int high, int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                if(mid ==0 || nums[mid-1]<nums[mid]){
                    return mid;
                } else {
                    high = mid-1;
                }
            } else if(nums[mid]<target){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return -1;
    }
    public int secondBinarySearch(int[] nums , int low, int high, int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                if(mid == nums.length-1 || nums[mid+1]>nums[mid]){
                    return mid;
                } else {
                    low = mid+1;
                }
            } else if(nums[mid]>target){
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return -1;
    }
}