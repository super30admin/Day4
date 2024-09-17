# Time: O(logn)
# Space: O(n)
class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        left = 0
        right = len(nums) - 1
        while left <= right:
            middle = (left+right) / 2
            #print(left, right, middle)
            if (middle-1 < 0 or nums[middle-1] < nums[middle]) and (middle+1 >= len(nums) or nums[middle+1] < nums[middle]):
                return middle
            elif (middle-1 >= 0 and nums[middle-1] > nums[middle]):
                right = middle - 1
            else:
                left = middle + 1
        #print(left, right)
        
