class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        '''O(logn) time complexity
            O(1) space complexity'''
        low=0
        high=len(nums)-1
        while low<=high:
            mid=low+(high-low)//2
            #single element case- peak will be the element itself
            if len(nums)==1:
                return 0
            #if mid is first element, check if the next element is less than it
            if mid==0 and nums[mid+1]<nums[mid]:
                return mid
            #if mid is last element,check if the element before is less than it
            elif mid==len(nums)-1 and nums[mid-1]<nums[mid]:
                return mid
            #check if mid is the peak 
            elif nums[mid]>nums[mid-1] and nums[mid]>nums[mid+1]:
                return mid
            #if none of above conditions satisfy,go to the side where the adjacent element is higher than the mid element.
            else:
                
                if nums[mid]<nums[mid+1]:
                    low=mid+1
                else :
                    high=mid-1
            
                
        