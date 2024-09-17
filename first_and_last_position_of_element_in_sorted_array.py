# A brute force solution to this would have been to run linear search two times on the array starting from 0 and starting from len(arr)-1 and store the indices
# Time Complexity of that would have been O(n)
# Space Complexity of that would have been O(1)


# Time Complexity : O (log n) , to run the binary search two times
# Space Complexity : O (1)
# Did this code successfully run on Leetcode : yes, but after multiple attempts with different versions of code
# Any problem you faced while coding this : Initially the approach was, find an element occurance using binary search, then the lower and upper bounds using separate searches
#ran into some code issues, did not get edge cases

# Your code here along with comments explaining your approach
# this version is given array is sorted, in one pass we try to find first occurance, 2nd pass the last
# modified binary search, keeps tracks of the previous matched occurance 

class Solution:    
    def find_first_index(self, arr, target, l, r):
        result = -1
        
        while(l<=r):
            mid = l + (r-l)//2
            if(arr[mid]==target):
                result = mid
                r = mid-1
            elif(arr[mid]<target):
                l = mid+1
            else:
                r = mid-1
        
        return result       
    
    def find_last_index(self, arr, target, l, r):
        result = -1
        
        while(l<=r):
            mid = l + (r-l)//2
            if(arr[mid]==target):
                result = mid
                l = mid+1
            elif(arr[mid]<target):
                l = mid+1
            else:
                r = mid-1
        
        return result       
                   
    def searchRange(self, nums: List[int], target: int) -> List[int]:
                
        l_b = self.find_first_index(nums, target, 0, len(nums)-1)
        u_b = self.find_last_index(nums, target, 0, len(nums)-1)
        
        return [l_b, u_b]

"""
class Solution:
    def binary_search(self, arr, target):
        l = 0
        r = len(arr)-1
        
        while(l<=r):
            mid = l + (r-l)//2
            if(arr[mid]==target):
                return mid
            elif(arr[mid]<target):
                l = mid+1
            else:
                r = mid-1
        
        return -1
    
    def find_last_index(self, arr, l, r, target):
        while(l<r):    
            mid = l + (r-l)//2
            if(arr[mid]>target):
                r = mid-1
            else:
                if(l==mid):
                    break
                l = mid
        
        if(arr[r]==target):
            return r
        
        return l
        
    
    def find_first_index(self, arr, l, r, target):
        while(l<r):    
            mid = l + (r-l)//2
            if(arr[mid]<target):
                l = mid+1
            else:
                r = mid

        return l        
                    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        i = self.binary_search(nums, target)
        
        if(i==-1):
            return [-1, -1]
        
        l_b = self.find_first_index(nums, 0, i, target)
        u_b = self.find_last_index(nums, i, len(nums)-1, target)
        
        return [l_b, u_b]
"""        