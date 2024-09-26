// Time Complexity : O(log n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    public int findMin(int[] nums) {
        int l=0;
        int h=nums.length-1;
        //int min;
        while(l<h)
        {
            int mid=l+(h-l)/2;
            if(nums[mid] > nums[h])
            {
                l = mid + 1;
            }
            else{
                h = mid;
            }
            
        }
        return nums[l];
    }
}