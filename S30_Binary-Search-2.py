# Find First and Last Position of Element in Sorted Array_Solution_Q1

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums is None or len(nums) == 0:
            return [-1, -1]
        
        first = self.binarySearchFirst(nums, target)
        if first == -1:
            return [-1, -1]
        
        last = self.binarySearchLast(nums, target)
        return [first, last]

    def binarySearchFirst(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                # Check if it is the first occurrence
                if mid == 0 or nums[mid - 1] != target:
                    return mid
                else:
                    high = mid - 1  # Keep searching on the left
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        
        return -1

    def binarySearchLast(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                # Check if it is the last occurrence
                if mid == len(nums) - 1 or nums[mid + 1] != target:
                    return mid
                else:
                    low = mid + 1  # Keep searching on the right
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        
        return -1


# TC O(log n)
# SC O(1)

------------------------------------------------------------------------------------------------------------------------------------------
# Find Minimum in Rotated Sorted Array_Solution_Q

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        
        low = 0
        high = len(nums) - 1
        while(low <= high):
            mid = low + (high - low) // 2
            if nums[low] <= nums[high]:
                return nums[low]
            if (mid == low or nums[mid] < nums[mid -1]) and (mid == high or nums[mid] < nums[mid +1]): #compare mid element
                return nums[mid]

            if(nums[low] <= nums[mid]): #left sorted
                low = mid +1 #move to right side
            else:
                high = mid -1

# TC O(log n)
# SC O(1)

---------------------------------------------------------------------------------------------------------------------------------------
# Find Peak Element_Solution_Q3

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if nums== None or len(nums) ==0:
            return -1
        if len(nums) ==1:
            return 0

        low =0
        high =len(nums)-1
        while(low <= high):
            mid =low +(high -low)// 2
            if (mid ==0 or nums[mid] > nums[mid-1]) and (mid==len(nums) -1 or nums[mid] > nums[mid+1]):
                return mid
            elif mid==0 or nums[mid] > nums[mid -1]:
                low= mid+1
            else:
                high= mid-1
        return 8888
    
# TC O(log n)
# SC O(1)