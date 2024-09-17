// LinkedIn interview question
//Time complexity = O(logn)
//Space complexity = O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null ||nums.length ==0) return new int[] {-1,-1};
        if(target < nums[0] || target > nums[nums.length-1]) return new int[] {-1,-1};
        int first = binarySearchFirstOccurrence(nums,target);
        if(first == -1) return new int[] {-1,-1};
        int last = binarySearchLastOccurrence(nums,target);
        return new int[] {first, last};
    }
    private int binarySearchFirstOccurrence(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;//To avoid integer overflow
            if(nums[mid]==target){
                //check if it is the first occurrence
                if(mid==0 || nums[mid-1] < nums[mid]){
                    return mid;
                } else {
                    high = mid-1;
                }
            }else if(target<nums[mid]){
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return -1;
    }
    private int binarySearchLastOccurrence(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;//To avoid integer overflow
            if(nums[mid]==target){
                //check if it is the first occurrence
                if(mid==nums.length-1 || nums[mid+1] > nums[mid]){
                    return mid;
                } else {
                    low = mid+1;
                }
            }else if(target<nums[mid]){
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return -1;
    }
      
 
}
