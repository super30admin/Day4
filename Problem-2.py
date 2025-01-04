#If the element is smaller than previous element or next is smaller than current element then print that element. Else keep searching the sorted array
#Time is O(logn)
#Space is O(1)
#Yes this worked in leetcode


class Solution:
    def findMin(self, nums: List[int]) -> int:
        first, last = 0, len(nums)-1
        if nums[first]<nums[last]  or len(nums)==1:
            return nums[first]
        while last>=first:
            mid = first + (last-first)//2
            if nums[mid-1]>nums[mid]:
                return nums[mid]
            if nums[mid]>nums[mid+1]:
                return nums[mid+1]
            if nums[mid]>nums[0]:
                first = mid + 1
            else:
                last = mid -1