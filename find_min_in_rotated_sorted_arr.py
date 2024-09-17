# Time Complexity : O(log (n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:
        if nums == None or not nums: return -1
        low, high = 0, len(nums) - 1
        while(low <= high):
            if(nums[low] <= nums[high]): return nums[low]
            mid = (low + high) // 2
            # to check if mid is smallest
            if ((mid == 0 or nums[mid] < nums[mid -1]) and (mid == len(nums) -1 or nums[mid] < nums[mid + 1])): 
                return nums[mid]
            elif nums[low] <= nums[mid]:
                low = mid + 1
            else: 
                high = mid - 1
                
sol = Solution()
print(sol.findMin([3]))