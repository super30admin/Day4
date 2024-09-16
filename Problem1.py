# Leetcode 34: Find First and Last Position of Element in Sorted Array
# Time complexity => Log(n) and O(1)
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        if len(nums) == 0:
            
            return [-1,-1]
        
        def searchLeftIndex(nums, target):
            
            start = 0
            end = len(nums)-1
            

            
            while(start <= end):
                
                mid = (start + end)//2
                
                if(nums[mid] == target and mid-1<0): 
                    return mid
                
                if(nums[mid] == target and nums[mid-1]!=target):
                    return mid

                if(target<=nums[mid]):
                    end = mid -1
                else:
                    start = mid+1
            return -1
        
        def searchRightIndex(nums, target):
            
            start = 0
            end = len(nums)-1
            
            
            while(start <= end):
                
                mid = (start + end)//2
                
                if(nums[mid] == target and mid+1==len(nums)): 
                    return mid
                if(nums[mid] == target and nums[mid+1]!=target):
                    return mid

                if(target>=nums[mid]):
                    start = mid+1
                else:
                    end = mid-1
            return -1
        
        return [searchLeftIndex(nums, target), searchRightIndex(nums, target)]