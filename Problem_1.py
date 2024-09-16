# Time Complexity :O(Log(n))
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    # find last occurance of target
    def binaryLast(self,nums,target):
        first = 0
        last = len(nums)-1
        while first <= last:
            mid = first + (last-first)//2
            # if you found target at last index or the number after it is bigger than it then you found your last position
            if nums[mid] == target and (mid == len(nums)-1 or nums[mid] < nums[mid+1] ):
                return mid
            #if mid less than or equal target continue searching right
            elif nums[mid] <= target:
                first = mid + 1
            #else search left
            else:
                last = mid - 1
        return -1
    # find first occurance of target
    def BinaryFirst(self,nums,target):
        first = 0
        last = len(nums)-1
        while first <= last:
            mid = first + (last-first)//2
            # if you found target at first index or the number before it is less than it then you found your first position
            if nums[mid] == target and (mid == 0 or nums[mid] >nums[mid-1] ):
                return mid
            # if mid less than target search right
            elif nums[mid] < target:
                first = mid + 1
            #if mid greater than or equal target search left
            else:
                last = mid - 1
        return -1
    
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # if no array or array is empty return -1 and -1
        if not nums or len(nums) == 0:
            return [-1,-1]
        #get first and last occurance
        First = self.BinaryFirst(nums,target)
        Last = self.binaryLast(nums,target)
        #return them
        return [First,Last]