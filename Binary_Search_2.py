"""
Problem 8
Find Minimum in Rotated Sorted Array
Approach 1: Linear Scan 
    TIme Complexity : O(n)
    Space Complexity : O(1)
"""
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        if not nums:
            return [-1,-1]
                
        for i in range(len(nums)):
            if nums[i] == target:
                fi = i
                break
        else:
            return [-1,-1]
                
        for j in range(len(nums)-1,-1,-1):
            if nums[j] == target:
                fj = j
                break
    
        return [fi,fj]
        
 """ 
    Approach 2: Binary Search
    TIme Complexity : O(log n)
    Space Complexity : O(1)
"""      
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        if not nums:
            return [-1,-1]
        
        low,high = 0,len(nums)-1
        
        def binarySearch(nums, low, high, flag):
     
            while low <= high:
                mid = low + (high - low ) //2
                
                if target == nums[mid]:
                    if flag == 1:
                        if mid ==0 or nums[mid]  > nums[mid - 1]:
                            return  mid
                        else:
                            high = mid - 1
                            
                    if flag == -1:
                        if mid == len(nums) -1 or nums[mid] < nums[mid + 1] :
                            return mid
                        else:
                            low = mid + 1
                                   
                
                elif nums[mid] < target  :
                    low = mid + 1
                else:
                    high  = mid -1
            
            return -1
        
        leftIndex = binarySearch(nums,low, high, 1)
        rightIndex = binarySearch(nums,low, high, -1)
            
        return [leftIndex, rightIndex]


"""
Problem 9
Find Minimum in Rotated Sorted Array
    TIme Complexity : O(log n)
    Space Complexity : O(1)
"""

class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        if len(nums) == 1:
            return nums[0]
        
        low = 0
        high = len(nums) -1
        
        if nums[high] > nums[0]:        
            return nums[0]              #if the last element is greater than first then the array is not rotated. Hence return first element
        
        while low <= high:
            mid = ( low + high ) //2
            
            if nums[mid] > nums[mid + 1]:   #if the mid element is greater than mid+1 element, then mid+1 element is smallest
                return nums[mid + 1]
            if nums[mid - 1] > nums[mid]:   #if the mid-1 element is greater than mid element, then mid element is smallest
                return nums[mid ]
            if nums[mid] > nums[low]:
                low = mid + 1           #if mid element is greater than low element, then search in second part of the array 
            else:
                high = mid - 1         #search in fist part
                
        return -1


"""
Problem 10
Find Peak Element
    Approach 1: Linear
    TIme Complexity : O(n)
    Space Complexity : O(1)
"""
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        """Scan the entire array linearly, if num[i] > nums[i+1] index found return it
        else return the index of last element"""
        
        if len(nums) == 1:
            return 0
        
        for i in range(len(nums)-1):
            
            if nums[i] > nums[i + 1]:
                return i
        else:
            return len(nums) - 1

"""
    Approach 2: Binary Search (recursively)
    TIme Complexity : O(log n)
    Space Complexity : O(1)
"""
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:

        def binarySearch(nums,low,high):
            if low == high:
                return low
            
            mid = low +(high - low ) // 2   #Compute the middle element
            
            """
            If mid element is greater than mid+1 element, then we should check the left part of mid
            else we should check for the peak element in right part of the mid element.
            """
            if nums[mid] > nums[mid + 1]:   
                return binarySearch(nums, low, mid )
            return binarySearch(nums, mid+ 1, high)
        
        return binarySearch(nums, 0, len(nums) -1 )