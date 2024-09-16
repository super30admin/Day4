// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    public int findMin(int[] nums) {
        int min=nums[0];
        int s=0;
        int e=nums.length-1;
        if(nums.length==0)
            return -1;
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            if(nums[0]<nums[1])
                return nums[0];
            else
                return nums[1];
        while(s<=e){
            int mid=s+(e-s)/2;
            if(nums[mid]<min)
                min=nums[mid];
            else if(e==s){
                return min;
            }
            else if(s>=0 && s<nums.length &&nums[s]<=min && nums[s]<nums[e])
                e=mid-1;
            else if(e>=0 && e<nums.length && nums[e]<=min && nums[e]<nums[s])
                s=mid+1;
            else
                return min;
        }
        return min;
        
    }
}