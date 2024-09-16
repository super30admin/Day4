// Time Complexity : O(LogN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findMin(int[] nums) {
        //initialize low and higher bounds
        int low=0, high=nums.length-1;
        //binary search
        while(low<=high){
            //checking if low is less than or equal to high
            if(nums[low]<=nums[high])
                //then array is sorted and return low value
                return nums[low];
            //now initialize mid
            int midValue=low+(high-low)/2;
            //checking if the mid Value is the smaller element among mid+1 and mid-1 and also checking is mid is 0 or the array size itself
            if((midValue==0||nums[midValue]<nums[midValue-1]) && (midValue==nums.length-1||nums[midValue]<nums[midValue+1]))
                return nums[midValue];
            //check if left array is sorted
            else if(nums[low]<=nums[midValue])
                //goto right array
                low=midValue+1;
            //or else we assume right array is sorted
            else
                //goto left array
                high=midValue-1;
        }
        return -1;
    }
}