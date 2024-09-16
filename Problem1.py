#Time Complexity:
# O( log(n))

#Space Complexity:
# O(1)

#Accepted

# Approach
# We are executing Binary Search twice, with a few added checks 
# First computing the first index by checking if each time the mid element is the first occurence of target (by checking the value + index behind it, if value == target)
# If first index not found, no last index exists
# If first index found, computing last index by checking if each time the mid element is the last occurence of target (by checking the value + index ahead of it, if value == target)
# Changing high/low bounds in both cases depending on which direction the first/last occurence of target will lie

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        if n == 0:
            return [-1, -1]
        
        low = 0
        high = n - 1
        firstOccIdx = self.findFirstIndex(nums, low, high, target)
        if firstOccIdx == -1: 
            return [-1, -1]
        
        secondOccIdx = self.findSecondIndex(nums, low, high, target)
        
        return [firstOccIdx, secondOccIdx]
        
        
        
    
    def findFirstIndex(self, A, low, high, target):
        while low <= high:
            mid = (low + high) // 2
            
            if A[mid] == target:
                if mid == 0 or A[mid - 1] != target:
                    return mid
                
                high = mid - 1
            
            else:
                if A[mid] < target:
                    low = mid + 1
                else:
                    high = mid - 1
                    
                    
        return -1
    
    def findSecondIndex(self, A, low, high, target):
        while low <= high:
            mid = (low + high) // 2
            
            if A[mid] == target:
                if mid == len(A) - 1 or A[mid + 1] != target:
                    return mid
                
                low = mid + 1
    
            else:
                if A[mid] < target:
                    low = mid + 1
                else:
                    high = mid - 1
                    
                    
        return -1
    
    

    
            
    
        