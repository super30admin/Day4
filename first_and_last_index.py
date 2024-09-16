# Time Complexity : Add - O(log n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

'''
I have used 2 modified binary search techinques - one for finding the first index, and, the other one for finding the last
index

'''

class Solution:
    
    def binarySearchLeft(self, arr, target):
        
        low = 0
        high = len(arr) - 1
        
        while(low <= high):
            mid = low + int((high - low)//2)
            
            if target == arr[mid]:
                if mid > low and arr[mid] == arr[mid-1]:
                    high = mid-1
                else:
                    return mid
                
            elif target < arr[mid]:
                high = mid - 1
            else:
                low = mid + 1
        else:
            return -1
                
    
    def binarySearchRight(self, arr, target):
        
        low = 0
        high = len(arr) - 1
        
        while(low <= high):
            mid = low + int((high - low)//2)
            
            if target == arr[mid]:
                if mid < high and arr[mid] == arr[mid+1]:
                    low = mid + 1
                else:
                    return mid
                
            elif target < arr[mid]:
                high = mid - 1
            else:
                low = mid + 1
        else:
            return -1
        
    
    def searchRange(self, nums, target):
        
        if nums == [] or len(nums) < 1:
            return [-1, -1]
        
        first_index = self.binarySearchLeft(nums, target)
        second_index = self.binarySearchRight(nums, target)
        
        return [first_index, second_index]
        
        