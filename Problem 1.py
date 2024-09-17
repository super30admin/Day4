# Time: O(logn)
# Space: O(1)
class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        left = 0
        right = len(nums) - 1
        start = -1
        while left <= right:
            middle = (left+right)/2
            if nums[middle] == target:
                if middle == 0 or nums[middle-1] != target:
                    start = middle
                    break
                else:
                    right = middle - 1
            elif nums[middle] < target:
                left = middle + 1
            else:
                right = middle - 1
        if start == -1:
            return [-1, -1]
        left = 0
        right = len(nums) - 1
        end = -1
        while left <= right:
            #print(left, right)
            middle = (left+right)/2
            if nums[middle] == target:
                if middle == len(nums)-1 or nums[middle+1] != target:
                    end = middle
                    break
                else:
                    left = middle + 1
            elif nums[middle] < target:
                left = middle + 1
            else:
                right = middle - 1
        return [start, end]
                
        
