#Running Time complexity: O(logn)
#Space Complexity: Constant or O(1)
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums)==0:
            return -1
        high = len(nums)-1
        low = 0
        while low<=high:
            mid = int(low+(high-low)/2)
            if (mid == len(nums)-1 or nums[mid]>nums[mid+1]) and (mid == 0 or nums[mid]>nums[mid-1]):                   
                return mid
            elif nums[mid]<nums[mid+1]:
                low = mid+1
            else:
                high = mid-1
             
        return -1
      

                