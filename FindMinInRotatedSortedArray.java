// Time Complexity : O(logn) n is size of input array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int findMin(int[] nums) {

        int n = nums.length;

        if(n==1)
            return nums[0];

        //if first ele is less than last ele, no rotation has happened
        if(nums[n-1] > nums[0])
            return nums[0];


        int l=0, h=n-1;

        //we try to find the point of inflection using binary search
        while(l<=h)
        {
            int m = l + (h-l)/2;

            //if mid ele is greater than next ele, next ele is min
            if(nums[m] > nums[m+1])
                return nums[m+1];

            //if mid ele is less than prev ele, prev ele is min
            if(nums[m] < nums[m-1])
                return nums[m];

            //if mid ele is greater than first ele, inflection is towards the right
            if(nums[0] < nums[m])
                l = m+1;
            //if mid ele is less than first ele, inflection is towards left
            else
                h = m-1;
        }
        return -1;
    }
}
