/*
   
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

Find the minimum element.

*/

//Time comlpexity - O(log n) 
//space complexity - O(1) 
// Did this code successfully run on Leetcode : Yes
/*
Any problem you faced while coding this : None

*/

// Your code here along with comments explaining your approach
public class Solution {
    public int findMin(int[] nums) {
        //edge case
        if(nums == null || nums.length ==0) return -1;
        
        int low = 0;
        int high = nums.length -1 ;
        
        while(low <= high)
        {
            if(nums[low] <nums[high])
              return nums[low];

            int mid = low + (high - low) /2 ; //mid value
            
            //find the min value with edge cases
            if((mid == nums.length-1 || nums[mid] < nums[mid +1]) 
               && (mid == 0 || nums[mid] < nums[mid-1]))
              return nums[mid];
            else if (nums[mid] < nums[high])
               high = mid -1; //move the high value towards lefto of mid
            else
               low = mid +1; //move low value to the right of the mid value

        }
        return -1;
    }
}