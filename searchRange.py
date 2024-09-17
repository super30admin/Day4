"""Binary search approach"""
#Accepted on leetcode
#Time complexity - O(logN)
#Space omplexity - O(1)

class Solution(object):
    res = []
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        def leftSearch(nums, low, high, target):
            while low<=high:
                mid = low + (high - low)//2
                
                if nums[mid] == target:
                    if low == mid or nums[mid-1] < nums[mid]:
                        return mid
                    else:
                        high = mid - 1
                elif nums[mid] < target:
                    low = mid + 1
                else:
                    high = mid - 1
            return -1
                    
        def rightSearch(nums, low, high, target):
            while low<=high:
                mid = low + (high - low)//2
                
                if nums[mid] == target:
                    if high == mid or nums[mid] < nums[mid+1]:
                        return mid
                    else:
                        low = mid + 1
                elif nums[mid] < target:
                    low = mid + 1
                else:
                    high = mid - 1
            return -1
        
        left = leftSearch(nums, 0, len(nums)-1, target)
        right = rightSearch(nums, 0, len(nums)-1, target)
        return [left,right]