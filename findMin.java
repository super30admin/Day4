  
// Time Complexity :O(Logn) N is the array size
// Space Complexity : O(1) since constant elements in the array;
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I couldn't crack the complete logic so had to take some help from discussions on leetcode


// Your code here along with comments explaining your approach

class Solution {
    public int findMin(int[] nums) {
        int high = nums.length-1;
        int low = 0;
        //base condition #1
        if (nums == null || nums.length == 0) {
            return -1;
        }
        //base condition #2
        if(nums.length ==1)
        {
            return nums[0];
        }
        while(low<=high)
        {
            int mid = low +(high-low)/2;
            if(mid>0 && nums[mid-1]>nums[mid])
            {
                return nums[mid];
            }
            
            //check for the sorted array
            if(nums[low]<=nums[mid] && nums[mid] > nums[high])
            {
                low = mid+1;
            }
            else
            {
                high = mid -1;
            }
            
            
        }
        
        return nums[low];
        
    }
}