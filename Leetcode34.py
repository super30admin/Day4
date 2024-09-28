class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        
        
        left = self.binarysearch(nums, target, True)
        right = self.binarysearch(nums, target, False)
        return (left,right)
        
        
        
    def binarysearch(self, nums, target, IsLeft):
            
        l = 0
        r = len(nums) - 1
        i = -1
        while l <= r:
            mid = (l + r) // 2
            if nums[mid] > target:
                r = mid - 1
            elif nums[mid] < target:
                l = mid + 1
            else:
                i = mid
                if IsLeft:
                    r = mid - 1
                else:
                    l = mid + 1
        return i
        