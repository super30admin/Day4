# Time-Complexity: O(log(n))
# Space-Complexity: O(1)
# Solved in leetcode: yes
# Problem? : No

import bisect
from curses.ascii import SO
class Solution:
    def findMin(self, nums):
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            if nums[0] < nums[1]: return nums[0]
            else: 
                return nums[1]
        left, right = 0, len(nums) - 1
        while(left<=right):
            mid = (left+right)//2
            
            # Check for the answer right away
            if nums[left] <= nums[right]: return nums[left]
            
            # check bounds and also check if the mid is actually the lower element when compared to left and right
            if (mid == 0 or nums[mid-1] > nums[mid]) and (mid == len(nums)-1 or nums[mid] < nums[mid+1]): return nums[mid]
            else:
                # Goal is to go towards unsorted half
                # left sorted check
                if nums[left] <= nums[mid]: left = mid + 1
                else: right = mid - 1

obj = Solution()
print(obj.findMin([3,4,5,1,2]))