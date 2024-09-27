/*
class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 0 or nums is None:
            return -1
        
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            mid = (low+high)//2
            
            if nums[low] < nums[high]:
                return nums[low]
            
            elif (mid == low or nums[mid] < nums[mid-1]) and (mid==high or nums[mid] < nums[mid+1]):
                return nums[mid]
            
            elif nums[mid] >= nums[low]:
                low = mid + 1
            
            else:
                high = mid - 1
            
        return -1
*/


// Time Complexity : O(logn) where n is size of array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach: We build our logic on the fact that the unsorted portion will contain 
// the minimum. Accordingly we eliminate the half of the list every time

class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        
        int low = 0, high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if (nums[low] < nums[high])
                return nums[low];
            
            else if((mid == low || nums[mid] < nums[mid-1]) &&(mid == high || nums[mid]<nums[mid+1]))
                return nums[mid];
            
            else if(nums[mid] >= nums[low])
                low = mid + 1;
            
            else
                high = mid - 1;
        }
        
        return -1;
        
            
    }
}