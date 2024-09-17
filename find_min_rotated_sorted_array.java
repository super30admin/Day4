// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length-1;

        while(start <= end)
        {
            //start to end is sorted
            if(nums[start] <= nums[end])
            {
                return nums[start];
            }

            int mid = start + (end - start)/2;

            //mid is minimum
            if(mid != 0 && nums[mid] < nums[mid-1])
            {
                return nums[mid];
            }

            //left sorted
            if(nums[start] <= nums[mid])
            {
                start = mid + 1;
            }
            //right sorted
            else 
            {
                end = mid - 1;
            }
        }
        return 5001;
    }
}