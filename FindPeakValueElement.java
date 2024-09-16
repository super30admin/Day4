// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : struggled with the case when mid was first index or last index


// Your code here along with comments explaining your approach

1.Using Binary search find middle element and check if it is greater than its neighbor elements
2. else if left is bigger go left side else go right side and  keep repeating until start index <= end index 

class Solution {
    public int findPeakElement(int[] nums) {
        
        // null case
        if(nums.length == 0 || nums == null)
            return -1;
        
        int start = 0;
        int end = nums.length-1;
       // int mid = start +(end-start)/2;
        
        while(start<=end)
        {
           int  mid = start +(end-start)/2;
           
            // is mid a peak value
            if((mid == 0 || nums[mid]> nums[mid-1]) && (mid == nums.length -1 || nums[mid] > nums[mid+1]))
            {
                return mid;
                
            }
            else if( mid > 0 && nums[mid-1] > nums[mid]) // if left number is bigger than mid number
            {
                 // move left
                end = mid-1;
            }
            else
            { //move right
                start = mid+1;
            }
          
        }
       
        return -1;
    }
}