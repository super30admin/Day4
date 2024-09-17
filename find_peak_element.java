// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : a little while considering mid conditions but overcame by mapping all mid possibilites


// Your code here along with comments explaining your approach


//nums[i] != nums[i+1]  - invalid case
class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length-1;

        while(start <= end)
        {
            int mid = start + (end - start)/2;

            boolean gtThanLeft = mid == 0 || nums[mid] > nums[mid-1];
            boolean gtThanRight = mid == nums.length-1 || nums[mid] > nums[mid+1];

            if(gtThanLeft && gtThanRight)
            {
                return mid;
            }

            else if(gtThanLeft) //move right and no need to consider left
            {
                start = mid + 1;
            }

            else            //move left and either the next element is peak or it will increase to the some point or the laasr element will be the peak
            {
                end = mid - 1;
            }
        }

        return -1;
    }
}