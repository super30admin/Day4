'''
T.C: O(log N)
S.C: O(1)

Intuition: if mid matches the cond., then return, else move the window to left or right if they are greater
- 
'''
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        nums_len = len(nums)
        if not nums_len:
            return -1
        
        start, end = 0, nums_len - 1
        
        while start <= end:
            mid = start + (end - start) // 2
            
            if (mid == 0 or nums[mid - 1] < nums[mid]) and (mid == nums_len - 1 or nums[mid] > nums[mid + 1]):
                return mid
            
            if mid != 0 and nums[mid - 1] > nums[mid]:
                end = mid - 1
            else:
                start = mid + 1
                
        
        