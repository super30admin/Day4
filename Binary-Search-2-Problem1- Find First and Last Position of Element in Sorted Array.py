"""
 FAANMG Problem #8 {Medium }

Problem 1
34. Find First and Last Position of Element in Sorted Array

Time Complexity : O( log n)
 

Space Complexity : O(1)
Constant Space 

Did this code successfully run on Leetcode : Yes

For this Problem I have used 3 binary Search mothods 
    - 1: To Find if the target element is in the nums array and get the target index
    - 2: To find the starting position im using binarySearchLeft with a chnage in the condition to get the first occurance
            if(arr[mid]==target): then this means the value for the previous targert index to the new mid in the left half contains the 
            target element, So i will take the left subhalf to check if there are any elements alailable and chnage the
            right pointer to mid -1
    - 3: Similarly to find the end position in checking if(arr[mid]==target): and then check like above if the element exist in the 
            right sub half and je tje last position
    For Both the scenario Im storing the position index obtained from the first binary search call and updating accordingly based on the other left and right
    binary search
    
@name: Rahul Govindkumar_RN27JUL2022
"""


class Solution:
    
    def binarySearch(self, arr, target, l, r ):
        
        while(l <= r):
            
            mid = (l+r)//2
            
            if(arr[mid]==target):
                return mid
            
            if(target < arr[mid]):
                r = mid-1
            else:
                l = mid+1
                
        
        return -1
    
    def binarySearchLeft(self, arr, target, l, r, i):
        
        i =i
        while(l <= r):
            
            mid = (l+r)//2
            
            if(arr[mid]==target):
                i =  mid
                r = mid-1
            
            if(target > arr[mid]):
                l  = mid +1
           
        
        return i
    
    def binarySearchRight(self, arr, target, l, r ,j):
        
        j =j
        while(l <= r):
            
            mid = (l+r)//2
            
            if(arr[mid]==target):
                j =  mid
                l = mid+1
            
            if(target < arr[mid]):
                r  = mid -1
           
        
        return j
    
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        size = len(nums)-1
        target_1 = self.binarySearch(nums, target, 0, size)
        
        
        
        if(target_1 != -1):
            i = self.binarySearchLeft( nums , target, 0, target_1 -1 , target_1)
            j = self.binarySearchRight( nums , target, target_1 + 1 , size ,target_1)
            return [i,j]
        else: 
            return [-1,-1]