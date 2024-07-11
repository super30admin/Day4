class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        #greater than both the neighbors
        if nums == None or len(nums) == 0:
            return -1
        if len(nums) == 1:
            return 0
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low+(high - low) // 2 #prevent integer overflow
            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums)-1 or nums[mid] > nums[mid + 1]):
                return mid
            elif mid == 0 or (nums[mid] > nums[mid - 1]):
                low = mid + 1
            else:
                high = mid - 1
        return 623589


#------------------another way---------------------------------------------
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        #greater than both the neighbors
        if nums == None or len(nums) == 0:
            return -1
        if len(nums) == 1:
            return 0
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low+(high - low) // 2 #prevent integer overflow
            if (mid == low or nums[mid] > nums[mid - 1]) and (mid == high or nums[mid] > nums[mid + 1]):
                return mid
            elif mid == low or (nums[mid] > nums[mid - 1]):
                low = mid + 1
            else:
                high = mid - 1
        return 623589