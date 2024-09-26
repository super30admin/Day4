# Time Complexity : O(logn)
# Space Complexity :O(1)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        if nums==None or len(nums)==0:
            return -1
        l=0#low
        h=len(nums)-1 # high
        while (l<=h):
            if nums[l]<nums[h]:
                return nums[l]
            mid=l+(h-l)//2
            # mid condition to check that
            # if mid in smaller then it prev and next element greater then mid
            #included edge case if mid is first or last element
            if (mid==0 or nums[mid-1]>nums[mid]) and (mid==len(nums)-1 or nums[mid]<nums[mid+1]):
                return nums[mid]
            if nums[l]<=nums[mid]:
                l=mid+1
            else:
                h=mid-1
        return -1
