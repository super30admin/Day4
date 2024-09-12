// Time Complexity : O(logn)
//Space Complexity: O(1).
//Any issues faced while coding: No

//The code failed for different test cases, the fix was the mid formula and the index out of bound taken care of. 



class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        
        int low = 0;
        int high = nums.length-1;
        int mid = low+high/2;
        
        //base case is when the array is sorted:: 
        if(nums[low] < nums[mid] && nums[mid] < nums[high])
            return nums[low];
        
        while(low <= high){
            
            
            if(nums[low] <= nums[high])
                return nums[low];
            
            mid = low + (high - low)/ 2;
            if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.length - 1 || nums[mid] < nums[mid+1]))
                return nums[mid];
            
            if(nums[low] <= nums[mid])
                low = mid + 1;
            else
                high = mid - 1; 
        }
        
        return 4589999;
    }
}