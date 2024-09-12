/*
This approach uses binary search to find the minimum element. It first detects which side
is the sorted side and then eliminates that side, moving onto the unsorted side. The logic 
behind this is that the minimum element will always lie on the unsorted side, unless the array
is completely sorted after all the rotations.

Problems faced while coding this: None

Did this run on leetcode: Yes

*/



class Solution {
    //Time Complexity = O(n)
    //Space Complexity = O(1)
    public int findMin(int[] nums) {
        
        int low = 0;
        int high = nums.length-1;
        int mid;
        
        
        while(low <= high)
        {
            mid = low +(high - low)/2;
            
            //Checking the case when the rotated array is alread fully sorted, or if we have entered a fully sorted subarray
            //In which case the minimum element is always the lowest element
            if(nums[low] <= nums[high])
                return nums[low];
            //Checking edge cases when mid is first, so that there is no index out of bounds during comparison
            if((mid == 0 || nums[mid] < nums[mid-1]) && (nums[mid] < nums[mid+1]))
                return nums[mid];
            
            else if(nums[mid] < nums[high])
                high = mid - 1;
            
            else if(nums[low] <= nums[mid])
                low = mid + 1;
        }
        
        return 1;
    }
}
