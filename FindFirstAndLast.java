/*
Time complexity of solution : O(log n)
Space COmplexity of solution : O(n)
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == -1){
            return new int[]{-1,-1};
        }
        int low=0;
        int high = nums.length-1;
        int first = binarySearchfirst(nums,target,low,high);
        int second = binarySearchLast(nums,target,low,high);
        return new int[]{first,second};
    }
    
    int binarySearchfirst(int[] nums,int target,int low,int high){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] == target){
                if((mid == low) || nums[mid-1]<nums[mid]){
                    return mid;
                }else{
                    high = mid-1;
                }
            }
            else if(target<nums[mid]){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
    
    int binarySearchLast(int[] nums,int target,int low,int high){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] == target){
                if((mid == high) || nums[mid]<nums[mid+1]){
                    return mid;
                }else{
                    low = mid+1;
                }
            }
            else if(target<nums[mid]){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
    
}