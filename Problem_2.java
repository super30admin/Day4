// Time Complexity :O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int low=0;
        int high=nums.length-1;
        int midPoint=0;
        while(low<=high){
           // System.out.println(high+","+low);
            midPoint=low+(high-low)/2;
            //System.out.println(midPoint);
            if((midPoint==0 || nums[midPoint]<nums[midPoint-1])&&(midPoint==nums.length-1 || nums[midPoint]<nums[midPoint+1])){
                return nums[midPoint];
            }else if(nums[midPoint]>=nums[low] && nums[midPoint]>nums[high]){
                low=midPoint+1;
            }else{
                high=midPoint-1;
            }
            //System.out.println("="+high+","+low);
            
        }
        return -1;
    }
}


