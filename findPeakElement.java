// Time Complexity : O(LogN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findPeakElement(int[] nums) {
       //intialize low and high values
        int low=0, high=nums.length-1;
        //apply binary search
        while(low<=high){
            //intialize mid value
            int midValue=low+(high-low)/2;
            //checking for the peak value 
            if((midValue==nums.length-1||nums[midValue]>nums[midValue+1])&&(midValue==0||nums[midValue]>nums[midValue-1])){
                return midValue;
            }
            //if midValue is not the peak go with the greater value next to mid value
            else if(midValue!=0 && nums[midValue-1]>nums[midValue]){
                high=midValue-1;
            }
            else{
                low=midValue+1;
            }
        }
        return -1;
    }
}