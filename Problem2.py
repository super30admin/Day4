# Time: O(logn)
# Space: O(1)
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        left = 0
        right = len(nums) - 1
        while left <= right:
            #print(left, right)
            middle = (left+right) / 2
            if (middle-1 < 0 or nums[middle-1] >nums[middle]) and (middle+1 >= len(nums) or nums[middle+1] >nums[middle]):
                return nums[middle]
            elif nums[middle] > nums[right]:
                left = middle + 1
            else:
                right = middle - 1
                
        
