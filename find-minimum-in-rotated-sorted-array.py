'''
T.C: O(log N)
S.C: O(1)

Intuition: when finding pivot / mid, atleast one half is always sorted.
- 
'''
class Solution:
    def findMin(self, nums: List[int]) -> int:
        nums_len = len(nums)
        if not nums_len:
            return -1
        
        start, end = 0, nums_len - 1
        low = float("INF")
        
        while start <= end:
            mid = start + (end - start) // 2
            low = min(low, nums[mid])
            
            if mid == 0 or (mid - 1 >= start and nums[start] <= nums[mid - 1]):
                low = min(low, nums[start])
                start = mid + 1
            elif mid == end or (mid + 1 <= end and nums[mid+1] <= nums[end]):
                low = min(low, nums[end])
                end = mid - 1
        
        return low
                            