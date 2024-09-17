# Time Complexity is O(logN)
# Space complexity is O(1)
# Move towards the higher element after finding mid
class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        def val(i):
            if(0 <= i < len(nums)):
                return nums[i]
            return -sys.maxint-1
        
        low = 0
        high = len(nums)-1
        while(low <= high):
            mid = (low+high)//2
            #print(mid)
            if(val(mid) > val(mid+1) and val(mid) > val(mid-1)):
                return mid
            elif(val(mid+1) > val(mid)):
                low = mid+1
            else:
                high = mid-1
        return -1