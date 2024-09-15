#time complexity = O(lon(n))
#Space complexity = O(1)
#Ran successfully on leetcode
#no problems faced 

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        left,right=0,len(nums)-1
        mid=(left+right)//2
        while right-left>1:
            if nums[mid]>nums[mid-1]:
                if nums[mid]>nums[mid+1]:
                    return mid
                else:
                    left=mid
            else:
                right=mid-1
            mid=(left+right)//2
        return mid if nums[mid]>nums[right] else right