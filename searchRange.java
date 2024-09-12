// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null||nums.length==0)
            return new int[] {-1,-1};
        if(nums[0]==target&&nums[nums.length-1]==target)
            return new int[]{0,nums.length-1};
        int left=binarysearchLeft(nums,target);
        if(left==-1)
               return new int[] {-1,-1};
        int right=binarysearchRight(nums,target,left);
         return new int[]{left,right};
         }
    private int binarysearchLeft(int[]nums,int target){
        int l=0;
        int h=nums.length-1;
        int mid;
        while(l<=h){
            mid=l+(h-l)/2;
            if(nums[mid]==target){
                if(mid==0||nums[mid-1]<nums[mid])
                    return mid;
                else
                    h=mid-1;
                    }
            else if(nums[mid]<target)
                l=mid+1;
            else
                h=mid-1;
        }
        return -1;
    }
     private int binarysearchRight(int[]nums,int target,int l){

        int h=nums.length-1;
        int mid;
        while(l<=h){
            mid=l+(h-l)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1||nums[mid+1]>nums[mid])
                    return mid;
                else
                    l=mid+1;
                    }
            else if(nums[mid]<target)
                l=mid+1;
            else
                h=mid-1;
        }
        return -1;
    }


}
