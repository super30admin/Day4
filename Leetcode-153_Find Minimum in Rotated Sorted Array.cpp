// Time Complexity : O(LogN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
 Minimise the search space using binary search using conditions
1. if array is already sorted with no rotation
2. if mid is the min ele or low/high is first or last ele in array.
3. if subarray is sorted return ele at low index else goto 4.
4. narrow down search space to right subarray changing low = mid+1 if low to mid is sorted else goto 5.
5. otherwise check in the left sub array changing high to mid-1.

*/

class Solution {
public:
    int findMin(vector<int>& nums) 
    {
        int low = 0;
        int high = nums.size()-1;
        
        //when array size is 1
        if(high==0)
            return nums[0];
        
        //given array is already sorted
        if(nums[low]<nums[high])
            return nums[low];
        
        
        while(low<=high)
        {
            int mid = (low+high)>>1;
            
            if(nums[low]<nums[high]) // the sub array is sorted
                return nums[low];
            
            //when mid is first, last or the min ele
            if((mid==0 || nums[mid]<nums[mid-1]) && 
                (mid==nums.size()-1 || nums[mid]<nums[mid+1])) 
                return nums[mid];
            
            // left half is sorted and min exists in right half
            if(nums[low]<=nums[mid]) 
                low = mid+1;
            
            // min exists in unsorted left half
            else
                high = mid-1;

        }
         return 0;
    }
   
};


