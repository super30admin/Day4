#Time Complexity : O(log n)
#Space Cpmplexity: 0(1)
class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        first=self.bfirst( nums, target)
        last=self.blast( nums, target)
        return [first,last]
    
    def bfirst(self, nums, target):
        l=0
        h=len(nums)-1
        while l<=h:
            mid=l+(h-l)/2
            if nums[mid]==target:
                if mid==0 or nums[mid]>nums[mid-1]:
                    return mid
                else:
                    h=mid-1
            elif nums[mid]>target:
                h=mid-1
            else:
                l=mid+1
        return -1


    def blast(self, nums, target):
        l=0
        h=len(nums)-1
        while l<=h:
            mid=l+(h-l)/2
            if nums[mid]==target:
                if mid==len(nums)-1 or nums[mid]<nums[mid+1]:
                    return mid
                else:
                    l=mid+1
            elif nums[mid]>target:
                h=mid-1
            else:
                l=mid+1
        return -1