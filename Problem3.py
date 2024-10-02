# TC and SC = O(logn)

class Solution:
    def binary_search(self, nums, low, high):
        while low < high:
            mid = ( low + high ) // 2

            if low == mid:
                if nums[low] > nums[high]:
                    return nums[low], low
                else:
                    return nums[high], high

            if nums[mid] > nums[mid-1] and nums[mid] > nums[mid+1]:
                return nums[mid], mid

            elif nums[mid] < nums[mid-1]: #left greater
                high = mid - 1

            else: #right Sorted
                low = mid + 1
        
        return nums[low], low 
                
    def findPeakElement(self, nums):
        high = len(nums)-1
        low = 0

        if high == 0:
            return 0

        if len(nums) - 1 < 2:
            if nums[0] < nums[1]:
                return 1
            else: 
                return 0
        
        minimum, position = self.binary_search(nums, low, high)
        return position 