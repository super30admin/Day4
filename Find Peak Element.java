/*
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            mid = (low+high) // 2
            
            if (mid == low or nums[mid] > nums[mid-1]) and (mid == high or nums[mid] > nums[mid+1]):
                return mid
            
            elif nums[mid] > nums[mid+1]:
                
                high = mid - 1
                
            else:
                low = mid + 1
        
        return -1
*/


// Time Complexity : O(logn) where n is size of array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach: We have proceed as usual as binary search with a modification that a peak
// is where an element is greater than its neighbours. If mid is not peak then we go further by checking which side is greater

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high){
            int mid = low + (high-low)/2;
            
            if ((mid == low || nums[mid] > nums[mid-1]) && (mid == high || nums[mid] > nums[mid+1]))
                return mid;
            
            else if(nums[mid] > nums[mid+1])
                high = mid - 1;
            else
                low = mid + 1;
        }
        
        return -1;
        
    }
}
