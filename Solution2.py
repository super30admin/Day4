class Solution(object):
    def findMin(self, nums):
        # find which side is sorted
        # if left side is sorted, min is to the right so low = mid+1
        # if right side is sorted mid is min or min is to the left
        low, high = 0, len(nums) - 1
        while low <= high:
            if nums[low] < nums[high]:
                return nums[low]
            mid = low + (high - low)/2
            # if mid is min - return mid
            if (mid == 0 or nums[mid] < nums[mid-1]) and (mid == len(nums) - 1 or nums[mid] < nums[mid+1]):
                return nums[mid]
            if nums[low] <= nums[mid]:
                # left is sorted
                low = mid + 1
            else: 
                # nums[high] > nums[mid]:
                high = mid - 1
        
        return nums[mid]
            