class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        def search(x):
            l, h = 0, len(nums)           
            while l < h:
                mid = (l + h) // 2
                if nums[mid] < x:
                    l = mid+1
                else:
                    h = mid                    
            return l
        
        l = search(target)
        h = search(target+1)-1
        
        if l <= h:
            return [l, h]
                
        return [-1, -1]