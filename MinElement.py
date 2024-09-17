class Solution(object):
    def findMin(self, nums):
        low, high = 0, len(nums) - 1
        if nums[low] <= nums[high]:
            return nums[0]
        while low <= high:
            mid = low + (high-low) / 2
            if nums[mid] > nums[mid+1]:
                return nums[mid + 1]
            if nums[mid-1] > nums[mid]:
                return nums[mid]
            if nums[low] <= nums[mid]:
                low = mid+1
            else:
                high = mid - 1
        return -1

"""
The approach here is to find the mid element and compare the mid element with mid+1 ,if mid is greater than
mid + 1 than we are here is the hinge point hence we can say mid+1 is the min element, else we compare mid-1
with the mid and if mid-1 is > than mid then we can say mid is the min element. if not both cases then we 
check if low is less than or equal to mid , if so left sub array is sorted, hence make low = mid+1 and search 
for hinge point in the right sub-array, if not then left sub-array is not sorted hence find for hinge point in
the left sub-array.
Time complexity - o(log n)
space complexity - o(1)
"""