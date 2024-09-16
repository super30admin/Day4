//time complexity:O(logn)
//space complexity:O(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=findFirst(nums,target);
        if(first==-1) return new int[] {-1,-1};
        int last=findLast(nums,target);
        return new int[] {first,last};
    }
    
    private int findFirst(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==0 || nums[mid]>nums[mid-1]){
                    return mid;
                }else{
                    high=mid-1;
                }
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
    
    private int findLast(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1 || nums[mid]<nums[mid+1]){
                    return mid;
                }else{
                    low=mid+1;
                }
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