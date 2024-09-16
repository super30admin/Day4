// Time Complexity :O(log n) worst case O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class Solution {
    public int findPeakElement(int[] nums) {
        int p1=1;
        int p2=nums.length-2;
        if(nums.length==1)
            return 0;
        if(nums.length==2)
        {
            if(nums[0]>nums[1])
                return 0;
            else
                return 1;
        }
        while(p1<=p2){
            if(nums[p1-1]<nums[p1] && nums[p1]>nums[p1+1])
                return p1;
            if(nums[p2-1]<nums[p2] && nums[p2]>nums[p2+1])
                return p2;
            p1=p1+1;
            p2=p2-1;
        }
        if(nums[0]>nums[nums.length-1])
            return 0;
        else
            return nums.length-1;
        
        
    }
}