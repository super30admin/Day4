'''
Time Complexity: O(logn)
Space Complexity: O(1)
'''
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if(len(nums)==1):
            return 0
        low = 0
        high = len(nums)-1
        while(low<=high):
            mid = (low+high)//2
            if((mid-1<0 or nums[mid]>nums[mid-1]) and (mid+1==len(nums) or nums[mid]>nums[mid+1])):
                return mid
            elif(nums[mid+1]>nums[mid]):
                low = mid+1
            else:
                high = mid-1
        return -1
        