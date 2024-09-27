//Time complexity: O(n)
//space complexity : O(1). 
//Complied on leetcode.

class Solution {
    public int findPeakElement(int[] nums) {
        
        for(int i=0; i<nums.length; i++)
        {
            if(i<nums.length-1 && nums[i]> nums[i+1])  // if element after is less and before is less or index is 0 return i.
            {
                if(i==0)
                    return i;
                if(nums[i]>nums[i-1])
                    return i;
                else
                    i++;								// the element after is already less so no need to check for next element so incrementing twice
            }
            else{
                if(i==nums.length-1)					// if element after is great and after element is last then return last number.
                    return i;
            }
            
        }
        return 0;
    }
}