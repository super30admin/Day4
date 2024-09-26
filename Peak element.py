#Time complexity:O(LogN)
#Space complexity:O(1)
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low=0
        high=len(nums)-1
        while low<=high:
            #Finding the middle element
            mid=low+(high-low)//2
            //checking if we found the peak or not
            if ((mid==0 or nums[mid]>nums[mid-1]) and (mid==len(nums)-1 or nums[mid]>nums[mid+1])):
                return mid
            #Going to left half for finding the peak
            elif (mid >0 and nums[mid-1]>nums[mid]):
                high=mid-1
                #Going to the right half to find the peak
            else:
                low=mid+1
        return -1
            