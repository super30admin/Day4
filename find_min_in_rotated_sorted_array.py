class Solution:
    def findMin(self, nums: List[int]) -> int:
        if not nums:
            return -1
        left = 0
        right = len(nums) - 1
        while left < right:
            mid = (left+right)//2
            if nums[mid] > nums[mid+1]:  # if the pivot is the next elemnt of the mid
                return nums[mid+1]
            if nums[mid-1] > nums[mid]:  # if the pivot is the previous element of the mid
                return nums[mid]
            if nums[left] > nums[mid]:  # if the left subarray is not sorted search there
                right = mid-1
            elif nums[mid] > nums[right]:  # if the right subarray is not sorted search there
                left = mid+1
            else:
                # if the entire array is sorted then you need to return the first element
                return nums[0]
        # if the array has just one element, then return the element itself
        return nums[0]
