# Time Complexity : O(logN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

'''
The key is to understand that the first element in the list can be used to partition the search space.
If the pivot is greater than the first element that means that the minimum is to the right of the pivot.
Otherwise the minimum is to the left of the pivot.
'''
class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        if len(nums) == 1:
            return nums[0]
        
        if nums[0] < nums[-1]:
            return nums[0]
        
        left = 0
        right = len(nums) - 1

        while left <= right:
            print(left, right)
            pivot = left + (right - left) // 2
            curr = nums[pivot]
            if curr < nums[pivot - 1]:
                return curr

            if curr < nums[0]:
                right = pivot - 1

            else:
                left = pivot + 1
            
        return -1