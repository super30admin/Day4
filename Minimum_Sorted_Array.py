class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0 
        high = len(nums) - 1
        temp = float('inf')
        while low < high:
            mid = (low+high) // 2
            if temp > nums[mid]:
                temp = nums[mid]
            if nums[mid] > nums[high]:
                low = mid+1
            elif nums[mid] < nums[low]:
                high = mid
            else:
                high = mid
        if nums[low] < temp:
            return nums[low]
        else:
            return temp