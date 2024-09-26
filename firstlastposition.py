#Time Complexity: O(log n)
#Space Complexity : O(1) as we only use pointers high, low,mid
#did your solution run on leetcode - yes

class Solution:
    def firstIndex(self,nums:List[int],target: int,low:int, high:int)->int:
            while(low <= high):
                mid = low + (high - low) //2
            
                if nums[mid] == target:
                    if mid == 0 or nums[mid - 1] < nums[mid] : #check whether mid element id greater than the prev element
                        return mid
                    else:
                        high = mid - 1
                
                elif nums[mid] < target:
                    low = mid + 1
                elif nums[mid] > target:
                    high = mid - 1
                    
            return -1
    #to find last index we take low = frist index
    def lastPosition(self,nums:List[int],target: int,low:int, high:int)->int:
        
            while(low <= high):
                mid = low + (high - low) //2
            
                if nums[mid] == target:
                    if (mid == len(nums)-1 or nums[mid] < nums[mid+1]): #check if next element greater than mid
                        return mid
                    else:
                        low = mid + 1
                elif nums[mid] < target:
                    low = mid + 1
                elif nums[mid] > target:
                    high = mid - 1
                    
            return -1
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if(len(nums)==0): return [-1,-1] #list is empty
        
        if(nums[0] > target or nums[len(nums)-1] < target ): return [-1,-1] #means target not in the list
        
        first = self.firstIndex(nums,target,0,len(nums)-1)
        
        if first == -1: return [-1,-1]
        last = self.lastPosition(nums,target,first,len(nums)-1)
        l = [first,last]
        return l
            
        
