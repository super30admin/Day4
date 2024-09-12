// Time Complexity : O(LogN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
1. Use binary search to reduce search space.
2. compare the mid with its neighbouring elements to see if its the peak element else goto 3.
3. check the mid-1 and mid+1 and narrow done search to subarray in which elements are in increasing order.

*/

class Solution {
    public:
        int findPeakElement(vector<int>& nums) 
        {
            int low =0, high = nums.size()-1;
            
            int mid;
            while(low<=high)
            {
                mid = low + (high-low)/2;
                
				// mid is the peak ele or when mid is first or last ele considering -infinity on both ends
                if((mid == 0 || nums[mid]>nums[mid-1])&& (mid == nums.size()-1 || nums[mid]> nums[mid+1]))
                   return mid;
                    
					// narrow down search space to the monotonically increasing side.
                else if(nums[mid+1]>nums[mid])
                    low = mid+1;
                    
                else
                    high = mid-1;
            }
                    
            return mid;        
        }
};