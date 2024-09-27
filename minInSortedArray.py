#Leetcode Problem: 153
class Solution:
    def findMin(self, nums):
        low=0
        high=len(nums)-1
        if nums[low]<=nums[high]:#if array is already in a ascensing order
            return nums[low]
        while(low<=high):
            mid=low+(high-low)//2
            if nums[low]<=nums[high]:
                return nums[low]
            if (mid==0 or nums[mid-1]>nums[mid]) and (mid==len(nums)-1 or nums[mid+1]>nums[mid]):
                #if elements on the both sides of the mid are greater
                return mid
            elif nums[low]<=nums[mid]:
                #move to unsorted part
                low=mid+1
            else:
                high=mid-1
        return -1
    
#TC = O(log n)
#SC = O(1)
