#find peak element
#TC:O(logN)
class Solution:
    
    def findPeakElement(self, nums: List[int]) -> int:
      
    
        def helper(nums,start,end):
            if start==end:
                return start

            elif (start+1==end):
                if(nums[start]>nums[end]):
                    return start
                return end
            else:
                m = (start+end)//2
                if (nums[m]>nums[m-1] and nums[m]>nums[m+1]):
                    return m
                elif (nums[m-1]>nums[m]and nums[m]>nums[m+1]):
                    return helper(nums,start,m-1)
                else:
                    return helper(nums,m+1,end)
        return helper(nums,0,len(nums)-1)