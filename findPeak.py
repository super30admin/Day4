"""
check if mid is greater than left and right neighbors, if yes that's the peak
else eliminate half of the array. Move towards higher slope i.e where the value is greater than mid
Time complexity: O(logn)
Spce complexity: O(1)
"""
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l, h = 0 , len(nums) - 1
        while l <=h:
            m = (l+h)//2
            if (m ==0 or nums[m] > nums[m-1] )and (m == h or nums[m] > nums[m+1]):
                return m
            if m>0 and nums[m] <nums[m-1]:
                h = m-1
            else:
                l = m+1
        
        