'''
To find the first and last index of an element, we can perform two binary searches, one for first index and one for last index. 

For first index, compute mid and check if target matches mid ele. If matches check if ele at mid-1 is smaller. If smaller, ele at mid is the first index, return mid value. If previous ele to mid is same as mid or if mid ele is greater than target, move leftwards to get first index, else move right.

For last index, take low as the start index value, and compute mid. If mid ele matches target, check if mid+1 ele is greater than mid ele. If greater, ele at mid is the last index, return mid value. If the next ele to mid is same as mid or if mid ele is smaller than target, move rightwards, else move left.

Time Complexity:O(1)
Space Complexity:O(1)

Passes all testcases in leetcode

'''


class Solution:
    def firstSearch(self,nums,target):
        low = 0
        high = len(nums)-1
        while(low<=high):
            mid = low+(high-low)//2
            if nums[mid] == target:
                if mid == 0 or nums[mid]>nums[mid-1]:
                    return mid
                elif nums[mid] == nums[mid-1]:
                    high = mid - 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1
    
    def lastSearch(self,nums,target,start):
        low = start
        high = len(nums)-1
        while(low<=high):
            mid = low+(high-low)//2
            if nums[mid] == target:
                if mid == len(nums)-1 or nums[mid]<nums[mid+1]:
                    return mid
                elif nums[mid] == nums[mid+1]:
                    low = mid + 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1
     
    
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        start = self.firstSearch(nums,target)
        
        if start == -1:
            return [-1,-1]
        last = self.lastSearch(nums,target,start)
        
        return([start,last])
        
