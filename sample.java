//Time Complexity :O(logn)
//Space Complexity :O(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length==0)return new int[] {-1,-1};
        int left = binarySearchLeft(nums,target);
        if(left!=-1){
            int right = binarySearchRight(nums,target,left);
            return new int [] {left,right};
        }
        return new int[]{-1,-1};
    }
    public int binarySearchLeft(int[]nums,int target){
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                if(mid==0|| nums[mid-1]<nums[mid] ){
                    return mid;
                }
                else{
                    high = mid-1;
                }
            }
            else if(nums[mid]<target){
                low =  mid+1;

            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
    public int binarySearchRight(int[]nums,int target,int low){
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1|| nums[mid]<nums[mid+1] ){
                    return mid;
                }
                else{
                    low = mid+1;
                }
            }
            else if(nums[mid]<target){
                low =  mid+1;

            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
}