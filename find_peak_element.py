# time complexity: O(log n)-binary search
# space complexity: O(1)-constant space
# Approach: check the mid with its neighbours, if greater than both neighbours, return mid
# else, move the search to the side of greater neighbour

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n=len(nums)
        if n==1:
            return 0
        l = 0
        r = n - 1
        while l <= r:
            mid = l + ((r - l) // 2)
            if ((mid == 0 or nums[mid] > nums[mid-1]) and (mid == n-1 or nums[mid] > nums[mid+1])): 
                return mid
            elif nums[mid] < nums[mid+1]:
                l = mid + 1
            else:
                r = mid - 1
        return -1
                
            
        