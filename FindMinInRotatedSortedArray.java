// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : yes, while formulating the approach


// Your code here along with comments explaining your approach

/*
Algorithm:
1) see the binary search.
2) go through mid and then compare mid<high
high =mid;
else search on right side.
low = mid;
and we return nums[low]


*/




class Solution {
    public int findMin(int[] nums) {
        
        int low=0;
        int high=nums.length-1;
        while(low<high)
        {
            int mid= low+(high-low)/2;
            
            if(nums[mid]<nums[high])
            {
                // search for left side
                
                high=mid;
                
            }
            else
            // right side
                low=mid+1;

            
        }
        
        return nums[low];
    }
}


