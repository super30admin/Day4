#34. Find First and Last Position of Element in Sorted Array

#Time complexity-> O(log n)
#Space Complexity -> O(1)



class Solution:
    def __binarySearchFirst(self,nums, target):
        low = 0
        high = len(nums)-1
        
        while(low<= high):
            mid = int(low+(high-low)/2)
            
            if(nums[mid]==target):
                if(mid == 0 or nums[mid]>nums[mid-1]):
                    return mid
                else:
                    high = mid-1 # keep moving left
            
            elif(nums[mid] < target):
                low = mid + 1
            else:
                high = mid -1
        return -1
    
    def __binarySearchLast(self,nums,target):
        low = 0
        high = len(nums)-1
       
        while(low<=high):
                mid = int(low+(high-low)/2)

                if(nums[mid]==target):
                    if((mid == len(nums)-1) or (nums[mid]<nums[mid+1])):
                        return mid
                    else:
                        low = mid +1 # keep moving righ
                elif(nums[mid] < target):
                    low = mid + 1
                else:
                    high = mid -1
        return -1        
       
    
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if(nums == None or len(nums) == 0):
            return [-1,-1]
        if((nums[0]  > target) or (nums[len(nums)-1] < target)):
            return [-1,-1]
        first = self.__binarySearchFirst(nums,target)
        last = self.__binarySearchLast(nums,target)
        return [first,last]  
         
        
        