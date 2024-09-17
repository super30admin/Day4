//Time Complexity : binary serach : O(logn) 
//Space: no recursive stack so O(1)
//ran on leetcode : yes
class Solution {
    //I am finding rotating point, which will always be minimum element
    public int findMin(int[] nums) {
        int start=0;
        int end=nums.length-1;
        //if there is 1 element, that will be the min
        if(nums.length==1)
            return nums[0];
        //if start< end ie array is sorted but not rotated, hence first elem is min
        if(nums[start]<nums[end])
        {
            return nums[0];
        }
        //do seach in whole array from left to right
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            // check if mid lies in right side and then mid is smaller than mid-1 so mid is changing point
            if(mid>start && nums[mid]<nums[mid-1])
                return nums[mid];
            //else if mid+1 is smaller than mid than rotating point is mid+1
            else if( nums[mid]>nums[mid+1])
                return nums[mid+1];
            //here is the catch :  if right half is sorted means min is not present here, look for left half
            else if(nums[end] > nums[mid])
            {
                end=mid-1;
            }
            //else look for right half
            else
            {
                start=mid+1;
            }
        }
        return -1;
    }
}
