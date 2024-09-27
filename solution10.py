#Time Complexity=O(log n)
#Space Complexity=O(1)
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low=0
        high=len(nums)-1
        if(len(nums)==1):
            return low
        if(len(nums)==2):
            if(nums[low]>nums[high]):
                return low
            else:
                return high
        while(low<=high):
            mid=int(low+(high-low)/2)
            if(mid==0 and (mid==high or nums[mid+1]<nums[mid])):
                return mid
            if(mid==high and (mid==0 or nums[mid-1]<nums[mid])):
                return mid
            if(nums[mid-1]<nums[mid]>nums[mid+1]):
                return mid
            if(nums[mid-1]>nums[mid]):
                high=mid-1
            else:
                low=mid+1
        return 0