#Problem 1
class Solution:
    
    #Time Complexity: O(log n)
    #Space Complexity: O(1)

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        # Helper function to find the lower bound of target
        def search(x):
            lo, hi = 0, len(nums)
            while lo < hi:
                mid = (lo + hi) // 2
                if nums[mid] < x:
                    lo = mid + 1
                else:
                    hi = mid
            return lo
        
        # Find the lower bound of the target
        lo = search(target)
        # Find the upper bound of the target
        hi = search(target + 1) - 1

        # Check if the target exists in the array
        if lo <= hi:
            return [lo, hi]
        return [-1, -1]


#Problem 2
class Solution:
    
    #Time Complexity: O(log n)
    #Space Complexity: O(1)

    def findMin(self, nums: List[int]) -> int:

        # Initialize low and high
        low, high = 0, len(nums) - 1

        # Iterate until low <= high
        while low <= high:

            # Check if the array is not rotated
            if nums[low] <= nums[high]:
                # Return nums[low] when the array is not rotated
                return nums[low]

            # Initialize mid if the array is rotated
            mid = (low + high)//2

            # Check the direction of traversal, 
            if nums[low] > nums[mid]:
                high = mid
            else:
                low = mid + 1


#Problem 3
class Solution:
    
    #Time Complexity: O(log n)
    #Space Complexity: O(1)
    

    def findPeakElement(self, nums: List[int]) -> int:
        # Initialize left and right indices
        l, r = 0, len(nums) - 1

        # Iterate until left <= right
        while l <= r:
            # Calculate mid index
            m = (l + r) // 2

            # Check if mid element is smaller than its left neighbor
            if m > 0 and nums[m] < nums[m - 1]:
                r = m - 1
            # Check if mid element is smaller than its right neighbor
            elif m < len(nums) - 1 and nums[m + 1] > nums[m]:
                l = m + 1
            else:
                return m
        return -1


