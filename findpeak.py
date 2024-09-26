class Solution(object):
    def findPeakElement(self, nums):
        if len(nums)==0:
            return 
        if len(nums)==1:
            return 0
        for i in range(len(nums)):
            if(i==0 and nums[i]>nums[i+1]):
                return i
            elif(i==len(nums)-1 and nums[i]>nums[i-1]):
                return i
            elif (nums[i-1]<nums[i] and nums[i]>nums[i+1]):
                return i
nums=[1,2,3,1]
obj=Solution()
print(obj.findPeakElement(nums))