'''
As any one peak can be returned we can perform binary search. We find the mid of array and check both sides of mid, if ele at mid is greater return mid. If both left and right elements to mid are larger than mid element, we can either update the low or high. If only element left to mid is greater, update high and if only element right to mid is greater, update low. 
Time complexity:O(log(N))
Space complexity:O(1)
Passes all testcases in leetcode
'''
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1
        
        if low == high: return low
        
        while(low<=high):
            mid = low+(high-low)//2
            
            if (mid == 0 or nums[mid]>nums[mid-1]) and (mid == len(nums) -1 or nums[mid]>nums[mid+1]):
                return mid
            if mid > 0 and nums[mid]<nums[mid-1]:
                high = mid - 1
                
            elif mid < (len(nums)-1) and nums[mid]<nums[mid+1]:
                
                low = mid + 1
