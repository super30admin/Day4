#time complexity: o(logn), even when we perform 2 bin searches, 
#space complexity:o(1)
#passed all cases on LeetCode: yes
#difficulty faced:
# comments:in code
#https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

class Solution:
    def searchRange(self, nums: 'List[int]', target: int) -> 'List[int]':
        
        if nums == None or len(nums) == 0: return [-1,-1]
        
        if (target < nums[0] or target >nums[len(nums)-1]) : return [-1,-1]
        
        
        def BinarySearchLeft(nums, target):
            low = 0
            high = len(nums)-1
            while(low <= high):
                mid = low + (high-low)//2
                if(nums[mid] == target):
                    #in order to compare mid-1 we need to check 1st condition in this or so that the array doesnt go out of bounds
                    if(mid == 0 or nums[mid-1] < nums[mid]):
                        #second condition here means we found first position because element just before it is lower
                        return mid
                    #if we dont have 1st position yet which means mid-1 == mid, we have to check lesser indexes hence move the window left and perform bin search again
                    high = mid-1
                elif target < nums[mid]:
                #if target is less, then we can just move left othw just move right 
                    high = mid -1
                else:
                    low = mid+1
            return -1
        
        def BinarySearchRight(nums, target):
            low = 0
            high = len(nums)-1
            while(low <= high):
                mid = low + (high-low)//2
                if(nums[mid] == target):
                    if( mid == high or nums[mid+1] > nums[mid]):
                        #bec we have to find rightmost idx, we return this if number to right is greater
                        return mid
                    low = mid+1
                elif target < nums[mid]:
                    high = mid -1
                else:
                    low = mid+1
            return -1
        
        
        firstoccurance = BinarySearchLeft(nums,target)
        
        if firstoccurance == -1: return [-1,-1]
        secondccurance = BinarySearchRight(nums,target)
        return [firstoccurance,secondccurance]
        
        
                