// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
class Solution {
    public int findMin(int[] nums) {
        int l=0,mid;
        int h=nums.length-1;

        if(nums.length==0||nums==null)
            return -1;
         if(nums[l]<=nums[h])
            return nums[l];
        while(l<=h){
            if(nums[l]<=nums[h])
            return nums[l];

            mid=l+(h-l)/2;
            if(((mid==0)||(nums[mid-1]>nums[mid]))&& ((mid==nums.length-1)||(nums[mid]<nums[mid+1])))
                return nums[mid];
            if(nums[l]<=nums[mid])
              l=mid+1;
            else
              h=mid-1;

        }

       return -1;
    }
}