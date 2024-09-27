# First and last position of element in sorted array 


class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # 3rd argument is bias so tell which side to move to continue searching 
        # leftBias = true/false, if false result is right biased meaning look to the 
        # right side, else look to the left side and change pointers accordingly
        left = self.binarySearch(nums, target, True)
        right = self.binarySearch(nums, target, False)
        return [left, right]

    def binarySearch(nums, target, leftBias):
        l =0
        r = len(nums)-1
        i = -1

        while l <= r:
            mid = l + (r-h) //2
            if target > nums[mid]:
                l = mid+1
            elif target < nums[mid]:
                r = mid-1
            else:
                i = m
                if leftBias:
                    r = m -1
                else:
                    l = m + 1
        return i




