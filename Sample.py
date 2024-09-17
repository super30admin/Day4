# Problem 1: Find first and last occurance (using binary tree)

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        result = [-1,-1]; low = 0; high = len(nums)
        while low < high:
            mid = low + (high-low)//2
            if nums[mid] == target:
                high = mid
                result[0]=mid
                result[1]=mid
            elif nums[mid]<target:
                low = mid+1
            else:
                high = mid
        if result[0] == -1:
             return result
        low = result[0]+1
        high = len(nums)
        while low < high:
            mid = low + (high-low)//2
            if nums[mid] == target:
                low = mid+1
                result[1] = mid
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid
        return result
    
# Problem 2: find min element in rotated sorted array

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0; high = len(nums) - 1
        while low < high: 
            mid = low + (high - low)//2
            if (nums[mid] == nums[high]): 
                high -= 1; 
            elif (nums[mid] > nums[high]): 
                low = mid + 1
            else: 
                high = mid
        return nums[high]
    
# Problem 3: Find peak element (rotated array)

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low, high = 0, len(nums)-1
        while low <= high:
            mid = low + (high-low)//2
            if (mid-1 < 0 or nums[mid] > nums[mid-1]) and (mid+1 >= len(nums) or nums[mid] > nums[mid+1]):
                return mid
            elif mid-1 >= 0 and nums[mid] < nums[mid-1]:
                high = mid - 1
            elif mid+1 < len(nums) or nums[mid] < nums[mid+1]:
                low = mid + 1
        return low
    
 