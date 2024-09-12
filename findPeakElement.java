// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
class Solution {
    public int findPeakElement(int[] nums) {
        int l=0,mid;
        int h=nums.length-1;
        if(nums==null||nums.length==0)
            return -1;
        while(l<=h){
            mid=l+(h-l)/2;
            if((mid==nums.length-1||nums[mid]>nums[mid+1])&&(mid==0||nums[mid]>nums[mid-1]))
               return mid;
            else if(nums[mid]<nums[mid+1])
                l=mid+1;
            else
                h=mid-1;
        }
        return -1;
    }
}
