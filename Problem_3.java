// Time Complexity :O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int findPeakElement(int[] nums) {
        int low=0;
        int high=nums.length-1;
        int midPoint=0;
        while(low<=high){
            midPoint=low+(high-low)/2;
            if((midPoint==0 || nums[midPoint]>nums[midPoint-1]) && (midPoint==nums.length-1 ||nums[midPoint]>nums[midPoint+1])){
                return midPoint;
            }else if(midPoint>0 && nums[midPoint-1]>nums[midPoint]){
                high=midPoint-1;
            }else{
                low=midPoint+1;
            }
        }
        return -1;
    }
}


