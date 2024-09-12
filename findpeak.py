'''
time complexity = O(logn)
space complexity = O(1)
Approch : 
    exploring the direction with peak 
    if prev element is greater than exploer left 
    if next elemet is greater than explore right
    if cur is greater than prev and next return index of it 
    
'''
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1: return 0
        l = 0 
        h = n-1
        while (l<=h) :
            m = l + (h-l)//2
            if (m == 0 or nums[m-1] < nums[m]) and (m == n-1 or nums[m] > nums[m+1]):
                return m
            if m != 0  and nums[m-1] > nums[m]:
                h = m - 1
            else:
                l =m + 1
        
