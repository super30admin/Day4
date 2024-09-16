# minimum in rotated sorted array
class Solution(object):
    def findMin(self,nums):
        n = len(nums)
        if n == 1:
            return nums[0]
        low = 0
        high = n - 1
        
        while low <= high:
            mid = int(low + (high - low)/2)
            
            if nums[mid-1] > nums[mid]:
                return nums[mid]
            
            if nums[mid] > nums[high]:
                low = mid + 1
            else:
                high = mid - 1
        return -1

nums = [3,4,5,1,2]
obj = Solution()
print(obj.findMin(nums))