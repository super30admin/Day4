# Time Complexity : O(logN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

'''
I use a flag to mutate the same function to search in the left side and to search in the right side of the
search space. The left search looks for the first occurence. The right search looks for the last occurence.
'''
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        def searchInDirection(left, right, goLeft):
            foundIdx = -1
            while left <= right:
                pivot = left + (right - left) // 2
                if target == nums[pivot]:
                    foundIdx = pivot
                    if goLeft:
                        right = pivot - 1
                    else:
                        left = pivot + 1
                elif target < nums[pivot]:
                    right = pivot - 1
                else:
                    left = pivot + 1
            
            return foundIdx
        
        
        result = []
        result.append(searchInDirection(0, len(nums) - 1, True))
        result.append(searchInDirection(0, len(nums) - 1, False))
        
        return result




