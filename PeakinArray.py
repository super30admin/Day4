'''
time complexity: O(log(n))
space complexity: O(1)
Difficulty: Handling edge cases
'''

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if(len(nums)==1):
            return 0
        beg = 0
        end = len(nums)-1
        while(beg<=end):
            mid = (beg + end)//2
            if(mid==0):
                if(nums[mid+1]<nums[mid]):
                    return mid
                else:
                    beg = mid+1
                    continue
            
            if(mid==len(nums)-1):
                if(nums[mid-1]<nums[mid]):
                    return mid
                else:
                    end = mid -1
                    continue
               
            if(nums[mid]>nums[mid+1] and nums[mid]>nums[mid-1]):
                return mid
            if(mid!=len(nums)-1 and nums[mid]<nums[mid+1]):
                beg = mid + 1
            elif(mid!=0 and nums[mid]<nums[mid-1]): 
                end = mid - 1