// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :calculating time compplexity


// Your code here along with comments explaining your approach

Binary search by finding middleindex once we get the target go back and forth of index to get the first and last index

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] result = {-1,-1};
       
        // null
        if(nums == null)
            return result;
        
        int start = 0;
        int end = nums.length-1;
        
           int mid = start + (end-start)/2;
        while(start <= end)
        {
         mid = start + (end-start)/2;

            if(target == nums[mid] )
            {
                int i = mid;
                while(target == nums[i])
                {
                    i--;
                    if(i<start)
                        break;
                }
                result[0]= i+1;
                
                int j = mid;
                while(target == nums[j])
                {
                    j++;
                    if(j>end)
                        break;
                }
                result[1] = j-1;
                return result;
            }
            else  if(target > nums[mid] )
            {
               // go on right side 
                start = mid+1;
            }
             else 
            {
                 end = mid-1;
               // go on left side 
            }
           
         }
        
        return result;
    }
}

