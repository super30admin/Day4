//T: O(logN)
//S: O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = binarySearchLow(nums,target);

        if(low==-1)
            return new int[]{-1,-1};

        int high = binarySearchHigh(nums,target);

        return new int[]{low,high};
    }

    public int binarySearchLow(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(nums[mid]==target){
                if(mid==0 || nums[mid]>nums[mid-1]){
                    return mid;
                }
                end = mid-1;
            }else if(nums[mid]<target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return -1;
    }

    public int binarySearchHigh(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(nums[mid]==target){
                if(mid==nums.length-1 || nums[mid]<nums[mid+1]){
                    return mid;
                }
                start = mid+1;
            }else if(nums[mid]<target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return -1;
    }
}