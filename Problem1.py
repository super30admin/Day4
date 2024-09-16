# Time complexity: O(logn)
# Space complexity: O(1)
#  Did it run on leetcode: yes

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        index1 = -1
        index2 = -1
        start = 0
        end = len(nums)-1
        if len(nums) == 0:
            return [-1,-1]
        
      # search left of the array
        while start <= end:
            mid = (start + end) // 2
            if nums[mid] == target:
                index1 = mid 
                end = mid - 1
            elif target > nums[mid]:
                start = mid +1
            else:
                end = mid - 1
        if index1 == -1:
            return [-1,-1]
        
        #search right of the array
        start = 0
        end = len(nums)-1
        
        while start <= end:
            mid = (start + end) // 2
            if nums[mid] == target:
                index2 = mid 
                start = mid + 1
            elif target > nums[mid]:
                start = mid +1
            else:
                end = mid - 1
        
        return[index1, index2]