"""
Min always lies in unsorted half of the array
check if mid is lowere than left and right neighbors, if yes that's the minimum
else eliminate sorted part of the array. 
check the right side first to avoid edge case where both left and right are sorted, in that case minimum will lie in the left half
Time complexity: O(logn)
Spce complexity: O(1)
"""
class Solution:
    def findMin(self, nums: List[int]) -> int:
        l, h = 0, len(nums)-1
        n = len(nums)
        while l <=h:
            m = l + (h-l)//2
            if (m==0 or nums[m] < nums[m-1]) and (m+1==n or nums[m] < nums[m+1]):
                return nums[m]
            if nums[m]<nums[h]:
                h = m -1
            else:
                l = m+1
        