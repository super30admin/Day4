# Time Complexity O(logn)
#Space Complexity O(1)
#Executed on Leetcode
class Solution(object):
    def searchRange(self, nums, target):
        l = 0
        h = len(nums)-1
        f = self.first(nums, h, l, target)
        s = self.last(nums, h, l, target)
        return [f,s]

    def first(self,nums,h,l,target):
        while l<=h:
            mid = l + (h-l)/2
            if nums[mid] == target:
                if mid ==0 or nums[mid] > nums[mid-1]:
                    return mid
                h = mid -1
            elif nums[mid] > target:
                h = mid -1
            else:
                l = mid + 1
        return -1

    def last(self,nums,h,l,target):
        while l<=h:
            mid = l + (h-l)/2
            if nums[mid] == target:
                if mid == len(nums)-1 or nums[mid] < nums[mid+1]:
                    return mid
                l = mid +1
            elif nums[mid] > target:
                h = mid -1
            else:
                l = mid + 1
        return -1

        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
