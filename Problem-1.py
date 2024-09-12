class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        if not nums:
            return [-1,-1]
        return[self.first_occurence(nums,target),self.second_occurence(nums,target)]
        
    def first_occurence(self,nums,target):
        low=0
        high=len(nums)-1
        while low<=high:
            mid=(low+high)//2
            if nums[mid]==target:
                if mid-1>=0 and nums[mid-1]==target:
                    high=mid-1
                else:
                    return mid
            elif (nums[mid]>target):
                high=mid-1
            else:
                low=mid+1
        return -1
    def second_occurence(self,nums,target):
        low=0
        high=len(nums)-1
        while low<=high:
            mid=(low+high)//2
            if nums[mid]==target:
                if mid+1<len(nums) and nums[mid+1]==target:
                    low=mid+1
                else:
                    return mid
            elif(nums[mid]>target):
                high=mid-1
            else:
                low=mid+1
        return -1
        
            
                    
        