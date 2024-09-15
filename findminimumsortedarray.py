class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l = 0
        r = len(nums) - 1
        while l < r:
            mid  = l + int((r - l)/2)
            print(mid)
            if nums[l] <= nums[r]:
                return nums[l]
            if mid == 0 or nums[mid] < nums[mid - 1]:
                if mid == len(nums) - 1 or nums[mid] < nums[mid + 1]:
                    return nums[mid]
            elif nums[l] <= nums[mid]:
                l = mid + 1
            else:
                r = mid - 1
      