class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        '''O(logn) time complexity
            O(1) Space complexity'''
        
        def binarysearchleft(nums,target):
            low=0
            high=len(nums)-1
            
            while low<=high:
                mid=low+(high-low)//2
                #if middle element is target
                if nums[mid]==target:
                    #check if left element is also target,if not return mid,if yes
                    #do decrease high to mid-1 and repeat the process until the below condition is satisfied 
                    if mid==0 or (nums[mid-1]<nums[mid]):
                        return mid
                    else:
                        high=mid-1
                else:
                    if nums[mid]>target:
                        high=mid-1
                    else:
                        low=mid+1
            return -1
        def binarysearchright(nums,target):
            low=0
            high=len(nums)-1
            
            while low<=high:
                mid=low+(high-low)//2
                if nums[mid]==target:
                    #check if right element is also target,if not return mid,if yes
                    #do increase low to mid+1 and repeat the process until the below condition is satisfied 
                    if mid==len(nums)-1 or (nums[mid+1]>nums[mid]):
                        return mid
                    else:
                        low=mid+1
                else:
                    if nums[mid]>target:
                        high=mid-1
                    else:
                        low=mid+1
            return -1
            
        
        low=0
        high=len(nums)-1
        #check if array is empty
        if len(nums)==0:
            return [-1,-1]
        #checking if target is first and last element
        if nums[low]==target and nums[high]==target:
            return [low,high]
        #first target not found 
        first=binarysearchleft(nums,target)
        if first==-1:
            return [-1,-1]
        last=binarysearchright(nums,target)
        
        return [first,last]
        
        
        