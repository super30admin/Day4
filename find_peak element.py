#time complexity: O(logn), we are using binary search
#space complexity:o(1)
#passed all cases on LeetCode:yes
#difficulty faced: -
# comments: in the code
#https://leetcode.com/problems/find-peak-element/

class Solution:
    def findPeakElement(self, nums: 'List[int]') -> int:
        
        low = 0
        high = len(nums)-1
        
        if len(nums) == 1: return 0
        
        while low <= high:
            
            mid = low + (high-low)//2     
            #have to check for mid==low in case when mid is 1st element, mid-1 will be out of bounds, same when mid is high
            if( (mid == low or nums[mid] > nums[mid-1]) and (mid==high or nums[mid] > nums[mid+1])):
                return mid
            elif(mid == len(nums)-1 or (nums[mid] < nums[mid+1])):
                low = mid+1
            else:
                high = mid-1
        return -1