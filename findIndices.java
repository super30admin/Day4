class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = leftBinarySearch(nums,target,0,nums.length-1);
        int last = rightBinarySearch(nums,target,0,nums.length-1);
        return new int[]{first,last};
    }
    private int leftBinarySearch(int[] nums,int target,int low,int high){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==0 || nums[mid]>nums[mid-1]){
                    return mid;
                }else{
                    high = mid-1;
                }
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }


private int rightBinarySearch(int[] nums,int target,int low,int high){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==(nums.length-1) || nums[mid]<nums[mid+1]){
                    return mid;
                }else{
                    low = mid+1;
                }
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}