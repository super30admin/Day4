# Time Complexity : O(log N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return -1
        low, high = 0, len(nums) - 1

        while(low <= high):
            # check for sorted array
            if nums[low] <= nums[high]:
                return nums[low]
            
            mid = low + (high - low) // 2 # avoid interger flow 
            if (mid == 0 or nums[mid] < nums[mid - 1]) and ( mid == high or nums[mid] < nums[mid + 1]):
                return nums[mid]
            elif nums[low] <= nums[mid]: # left sorted 
                low = mid + 1
            else:
                high = mid - 1

        return 43545
            
        