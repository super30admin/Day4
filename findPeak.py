""" Time Complexity : O(log n)
Space Complexity : O(1)
Did it run on Leetcode : Only 30 out of 64 test cases passed. Not able to find the issue """

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if(len(nums)==0): return -1
        
        low = 0
        high = len(nums)-1
        
        while(low<=high):
            mid= int(low + ((high-low)/2))
            if((mid == len(nums)-1 or nums[mid] > nums[mid +1]) and (mid == 0 or nums[mid] > nums[mid-1])):
                return mid
            elif (mid != 0 or nums[mid-1] > nums[mid]):
                high=mid-1
            else:
                low=mid+1
        return -1
        