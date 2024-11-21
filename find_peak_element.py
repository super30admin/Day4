#find_minimum_rotated_sorted_array
#time complexity: O(logN)
#space complexity: O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : passing the edge case of single element i.e [1], [2] etc.

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        left = 0
        right = len(nums)-1
        while left <= right:
            mid = (left + right)//2
            if right == 0: 
                return 0
            if mid > 0 and mid < len(nums)-1:
                if nums[mid] > nums[mid-1] and nums[mid] > nums[mid+1]:
                    return mid
                elif nums[mid-1] > nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
                    
            else:
                if mid == 0:
                    if nums[mid] > nums[mid+1]:
                        return mid
                    else:
                        return mid+1
                if mid == len(nums)-1:
                    if nums[mid] > nums[mid-1]:
                        return mid
                    else:
                        return mid-1
            
        
       
