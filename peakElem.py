# Time com : O(logn) Space Com : O(1)
# Successful on leetcode


class Solution:
    def findPeak(self,nums):
        low = 0
        high = len(nums)-1
        while low <= high:
            mid = (low+high)//2
            #if mid is the peak then return mid. mid==low and mid==high are the edge cases we have to
            #check else it will give array index out of bound
            if (mid == low or nums[mid-1] < nums[mid]) and (mid == high or nums[mid] > nums[mid+1]):
                return mid
            elif nums[mid+1] > nums[mid]:
                low = mid+1
            else:
                high = mid-1
        return -1

obj = Solution()
print(obj.findPeak([1,2,1,3,5,6,4]))
print(obj.findPeak([1,2]))
