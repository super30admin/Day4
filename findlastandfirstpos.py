class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        def leftsearch(l, r):
            while l <= r:
                mid  = l + int((r - l)/2)
                if nums[mid] == target:
                    if mid == 0 or nums[mid] > nums[mid - 1]:
                        return mid
                    else:
                        r = mid
                elif target > nums[mid]:
                    l = mid + 1
                else:
                    r = mid - 1
            return -1  
        def rightsearch(l,r):
            while l<= r:
                mid = l + int((r - l)/2)
                if nums[mid] == target:
                    if mid == len(nums) - 1 or nums[mid] < nums[mid + 1]:
                        return mid
                    else:
                        l = mid + 1
                elif target > nums[mid]:
                    l = mid + 1
                else:
                    r = mid - 1
            return -1    
        l = 0
        r = len(nums) - 1
        k = leftsearch(l, r)
        if k == -1:
            return [-1,-1]
        else:
            z = rightsearch(k, r)
            return [k, z]